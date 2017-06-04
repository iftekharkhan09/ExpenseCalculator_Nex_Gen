package com.expensecalculator.ui.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StaffRegistrationBean {
	@NotNull
	@Size(min=6,max=30,message="Size should be between 6 and 30")
	private String userName;
	@NotNull
	@Size(min=6,max=30,message="Size should be between 6 and 30")
	private String password;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	@Size(min=6,max=30,message="Size should be between 6 and 30")
	private String email;
	@NotNull
	@Size(min=6,max=30,message="Size should be between 6 and 30")
	private String Organization;
	@NotNull
	@Size(min=10,max=10,message="Invalid Mobile No")
	private String phoneNo;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrganization() {
		return Organization;
	}

	public void setOrganization(String organization) {
		Organization = organization;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
