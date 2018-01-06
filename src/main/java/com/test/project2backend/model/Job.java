package com.test.project2backend.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Job_Data", schema = "oracledb")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer jobId;

	private String jobTitle;

	private String jobDescription;

	private Integer jobPackage;

	private String jobQualification;

	private String companyName;

	private String companyLocation;

	private String yearOfExperience;

	private Date jobPostedDate;

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Integer getJobPackage() {
		return jobPackage;
	}

	public void setJobPackage(Integer jobPackage) {
		this.jobPackage = jobPackage;
	}

	public String getJobQualification() {
		return jobQualification;
	}

	public void setJobQualification(String jobQualification) {
		this.jobQualification = jobQualification;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}

	public String getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(String yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	public Date getJobPostedDate() {
		return jobPostedDate;
	}

	public void setJobPostedDate(Date jobPostedDate) {
		this.jobPostedDate = jobPostedDate;
	}

}
