package com.test.project2backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.project2backend.dao.BlogDao;
import com.test.project2backend.model.Blog;

@Repository("blogDao") // for doing all database related operation we have
// to use @Repository annotation
@Transactional
public class BlogDaoImplementation implements BlogDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addBlog(Blog blog) {

		sessionFactory.getCurrentSession().save(blog);
		return true;
	}

	@Override
	public boolean deleteBlog(Blog blog) {

		sessionFactory.getCurrentSession().delete(blog);
		return true;
	}

	@Override
	public Blog getBlog(Integer id) {
		return (Blog) sessionFactory.getCurrentSession().get(Blog.class, id);
	}

	@Override
	public boolean updateBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> getALLBlogs() {
		return sessionFactory.getCurrentSession().createQuery("from Blog").getResultList();
	}

	@Override
	public Boolean approveBlogs(Blog blog) {
		Boolean bool=false;
		return bool;
	}

}
