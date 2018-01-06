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
	private Integer job_Id;

	private String job_Title;

	private String job_Description;

	private Integer job_Package;

	private String job_Qualification;

	private Date job_Posted_Date;

	private String company_Name;

	private String company_Location;

	private String year_Of_Experience;

	public Integer getJob_Id() {
		return job_Id;
	}

	public void setJob_Id(Integer job_Id) {
		this.job_Id = job_Id;
	}

	public String getJob_Title() {
		return job_Title;
	}

	public void setJob_Title(String job_Title) {
		this.job_Title = job_Title;
	}

	public String getJob_Description() {
		return job_Description;
	}

	public void setJob_Description(String job_Description) {
		this.job_Description = job_Description;
	}

	public Integer getJob_Package() {
		return job_Package;
	}

	public void setJob_Package(Integer job_Package) {
		this.job_Package = job_Package;
	}

	public String getJob_Qualification() {
		return job_Qualification;
	}

	public void setJob_Qualification(String job_Qualification) {
		this.job_Qualification = job_Qualification;
	}

	public Date getJob_Posted_Date() {
		return job_Posted_Date;
	}

	public void setJob_Posted_Date(Date job_Posted_Date) {
		this.job_Posted_Date = job_Posted_Date;
	}

	public String getCompany_Name() {
		return company_Name;
	}

	public void setCompany_Name(String company_Name) {
		this.company_Name = company_Name;
	}

	public String getCompany_Location() {
		return company_Location;
	}

	public void setCompany_Location(String company_Location) {
		this.company_Location = company_Location;
	}

	public String getYear_Of_Experience() {
		return year_Of_Experience;
	}

	public void setYear_Of_Experience(String year_Of_Experience) {
		this.year_Of_Experience = year_Of_Experience;
	}

}
