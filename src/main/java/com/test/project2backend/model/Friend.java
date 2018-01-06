package com.test.project2backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Friend_Data", schema = "oracledb")
@Entity
public class Friend {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private Integer friend_Id;

	private String friend_Name;

	private Integer user_Id;

	private String user_Name;

	private String is_Online;

	private char request_Status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFriend_Id() {
		return friend_Id;
	}

	public void setFriend_Id(Integer friend_Id) {
		this.friend_Id = friend_Id;
	}

	public String getFriend_Name() {
		return friend_Name;
	}

	public void setFriend_Name(String friend_Name) {
		this.friend_Name = friend_Name;
	}

	public Integer getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public String getIs_Online() {
		return is_Online;
	}

	public void setIs_Online(String is_Online) {
		this.is_Online = is_Online;
	}

	public char getRequest_Status() {
		return request_Status;
	}

	public void setRequest_Status(char request_Status) {
		this.request_Status = request_Status;
	}

}
