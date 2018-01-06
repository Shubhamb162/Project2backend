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

		job.setJobTitle("Tech Support");
		job.setJobDescription("Tech Support Engineer");
		job.setJobQualification("BE or B.Tech");
		job.setJobPackage(240000);
		job.setJobPostedDate(new java.util.Date());
		job.setYearOfExperience("0-2");
		job.setCompanyName("XYZ Technologies");
		job.setCompanyLocation("ABC");
		Assert.assertEquals("Data Entered Ureka", true, jobDao.addJob(job));
	}

	@Test
	public void deleteJobTest() {
		job = jobDao.getJob(16);
		Assert.assertEquals("Data Entered Ureka", true, jobDao.deleteJob(job));
	}

	@Test
	public void getJobTest() {
		job = jobDao.getJob(15);
		Assert.assertNotNull(job);
		System.out.println(job.getJobTitle());
	}

	@Test
	public void updateJobTest() {
		job = jobDao.getJob(15);
		job.setJobPackage(300000);
		Assert.assertEquals("Data Entered Ureka", true, jobDao.updateJob(job));
	}

	@Test
	public void getALLJobTest() {
		List<Job> jobList = jobDao.getALLJob();
		Iterator<Job> itr = jobList.iterator();

		Assert.assertEquals(true, itr.hasNext());
		// assertThat(jobList, not(IsEmptyCollection.empty()));
		// Assert.assertEquals("Job List", true, !(jobList.isEmpty()));
	}

}
