package com.test.project2backend;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.test.project2backend.dao.JobDao;
import com.test.project2backend.model.Job;

public class JobTesting {
	// we have to declare reference variables here to access it in any method
	private static AnnotationConfigApplicationContext context;

	private static JobDao jobDao;
	private static Job job;

	@BeforeClass
	public static void init() {
		// making object of AnnotationConfigApplicationContext
		context = new AnnotationConfigApplicationContext();
		// scanning the whole project for making bean objects
		context.scan("com.test.project2backend");
		// refresh the Spring Container
		context.refresh();
		// getting the beans of jobDao type
		jobDao = (JobDao) context.getBean("jobDao");
		job = new Job();

	}

	@Test
	public void addJobTest() {

		job.setJob_Title("Tech Support");
		job.setJob_Description("Tech Support Engineer");
		job.setJob_Qualification("BE or B.Tech");
		job.setJob_Package(360000);
		job.setJob_Posted_Date(new java.util.Date());
		job.setYear_Of_Experience("0-2");
		job.setCompany_Location("XYZ Technologies");
		job.setCompany_Location("ABC");
		Assert.assertEquals("Data Entered Ureka", true, jobDao.addJob(job));
	}

	@Test
	public void deleteJobTest() {
		job = jobDao.getJob(29);
		Assert.assertEquals("Data Entered Ureka", true, jobDao.deleteJob(job));
	}

	@Test
	public void getJobTest() {
		job = jobDao.getJob(30);
		Assert.assertNotNull(job);
		System.out.println(job.getJob_Title());
	}

	@Test
	public void updateJobTest() {
		job = jobDao.getJob(31);
		job.setJob_Package(300000);
		Assert.assertEquals("Data Entered Ureka", true, jobDao.updateJob(job));
	}

	@Test
	public void getALLJobTest() {
		List<Job> jobList = jobDao.getALLJob();
		Iterator<Job> itr = jobList.iterator();

		Assert.assertEquals(true, itr.hasNext());
	}

}
