package com.test.project2backend.dao;

import java.util.List;
import com.test.project2backend.model.Job;

public interface JobDao {

	public boolean addJob(Job job);

	public boolean deleteJob(Job job);

	public Job getJob(Integer id);

	public boolean updateJob(Job job);

	public List<Job> getALLJob();

}
