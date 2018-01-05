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
	private String clientName;

	@Size(min = 10, message = "You cannot entered lessthan 10 digits.")
	private String clientMobileNo;

	@Column(unique = true)
	@Pattern(regexp = ".+@.+\\..+", message = "Wrong email!")
	private String clientEmailId;

	@NotNull(message = "Please select a password")
	@Length(min = 5, max = 10, message = "Password should be between 5 - 10 charactes")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8}")
	private String clientPassword;

	private String clientConfirmPassword;

	private String role;

	public Integer getClient_Id() {
		return client_Id;
	}

	public void setClient_Id(Integer client_Id) {
		this.client_Id = client_Id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientMobileNo() {
		return clientMobileNo;
	}

	public void setClientMobileNo(String clientMobileNo) {
		this.clientMobileNo = clientMobileNo;
	}

	public String getClientEmailId() {
		return clientEmailId;
	}

	public void setClientEmailId(String clientEmailId) {
		this.clientEmailId = clientEmailId;
	}

	public String getClientPassword() {
		return clientPassword;
	}

	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}

	public String getClientConfirmPassword() {
		return clientConfirmPassword;
	}

	public void setClientConfirmPassword(String clientConfirmPassword) {
		this.clientConfirmPassword = clientConfirmPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
