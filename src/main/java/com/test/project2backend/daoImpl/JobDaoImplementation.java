package com.test.project2backend.daoImpl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.test.project2backend.dao.JobDao;
import com.test.project2backend.model.Job;

@Repository("jobDao") // for doing all database related operation we have
// to use @Repository annotation
@Transactional

public class JobDaoImplementation implements JobDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addJob(Job job) {
		sessionFactory.getCurrentSession().save(job);
		return true;
	}

	@Override
	public boolean deleteJob(Job job) {
		sessionFactory.getCurrentSession().delete(job);
		return true;
	}

	@Override
	public Job getJob(Integer id) {
		return (Job) sessionFactory.getCurrentSession().get(Job.class, id);
	}

	@Override
	public boolean updateJob(Job job) {
		sessionFactory.getCurrentSession().update(job);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Job> getALLJob() {
		return (List<Job>) sessionFactory.getCurrentSession().createQuery("from Job").getResultList();
	}
}
