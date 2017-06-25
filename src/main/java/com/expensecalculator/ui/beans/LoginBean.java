package com.expensecalculator.ui.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginBean {
	public LoginBean() {
	}

	public LoginBean(String userName, String organizationName, String password) {
		this.userName = userName;
		OrganizationName = organizationName;
		this.password = password;
	}

	@NotNull
	@Size(min=6,max=30,message="Size should be between 6 and 30")
	private String userName;
	@NotNull
	@Size(min=6,max=30,message="Size should be between 6 and 30")
	private String OrganizationName;
	@NotNull
	@Size(min=6,max=30,message="Size should be between 6 and 30")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrganizationName() {
		return OrganizationName;
	}

	public void setOrganizationName(String organizationName) {
		OrganizationName = organizationName;
	}

	
}
