package com.expensecalculator.ui.beans;

public class LoginBean {
	public LoginBean(String userName, int orgId, String password) {
		this.userName = userName;
		OrgId = orgId;
		this.password = password;
	}

	public LoginBean() {
	}

	private String userName;
	private int OrgId;
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

	public int getOrgId() {
		return OrgId;
	}

	public void setOrgId(int orgId) {
		OrgId = orgId;
	}
}
