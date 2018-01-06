package com.test.project2backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Table(name="Client_Data", schema="oracledb")
@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer client_Id;

	@Size(min = 5, max = 10, message = "Your name should be between 5 - 10 characters.")
	@Pattern(regexp = "[a-zA-Z]{5,10}")
	private String client_Name;

	@Size(min = 10, message = "You cannot entered lessthan 10 digits.")
	private String client_Mobile_No;

	@Column(unique = true)
	@Pattern(regexp = ".+@.+\\..+", message = "Wrong email!")
	private String client_Email_Id;

	@NotNull(message = "Please select a password")
	@Length(min = 5, max = 10, message = "Password should be between 5 - 10 charactes")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8}")
	private String client_Password;

	private String client_Confirm_Password;

	private String role;

	public Integer getClient_Id() {
		return client_Id;
	}

	public void setClient_Id(Integer client_Id) {
		this.client_Id = client_Id;
	}

	public String getClient_Name() {
		return client_Name;
	}

	public void setClient_Name(String client_Name) {
		this.client_Name = client_Name;
	}

	public String getClient_Mobile_No() {
		return client_Mobile_No;
	}

	public void setClient_Mobile_No(String client_Mobile_No) {
		this.client_Mobile_No = client_Mobile_No;
	}

	public String getClient_Email_Id() {
		return client_Email_Id;
	}

	public void setClient_Email_Id(String client_Email_Id) {
		this.client_Email_Id = client_Email_Id;
	}

	public String getClient_Password() {
		return client_Password;
	}

	public void setClient_Password(String client_Password) {
		this.client_Password = client_Password;
	}

	public String getClient_Confirm_Password() {
		return client_Confirm_Password;
	}

	public void setClient_Confirm_Password(String client_Confirm_Password) {
		this.client_Confirm_Password = client_Confirm_Password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	
}
