package com.test.project2backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Blog_Data", schema = "oracledb")
@Entity
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Integer blog_Id;

	String blog_Name;

	String blog_Content;

	String blogger_Name;

	String status;

	Integer likes;

	Date blog_Date;

	public Integer getBlog_Id() {
		return blog_Id;
	}

	public void setBlog_Id(Integer blog_Id) {
		this.blog_Id = blog_Id;
	}

	public String getBlog_Name() {
		return blog_Name;
	}

	public void setBlog_Name(String blog_Name) {
		this.blog_Name = blog_Name;
	}

	public String getBlog_Content() {
		return blog_Content;
	}

	public void setBlog_Content(String blog_Content) {
		this.blog_Content = blog_Content;
	}

	public String getBlogger_Name() {
		return blogger_Name;
	}

	public void setBlogger_Name(String blogger_Name) {
		this.blogger_Name = blogger_Name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Date getBlog_Date() {
		return blog_Date;
	}

	public void setBlog_Date(Date blog_Date) {
		this.blog_Date = blog_Date;
	}

}
