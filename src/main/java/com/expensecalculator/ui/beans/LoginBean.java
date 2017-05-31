package com.expensecalculator.ui.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginBean {
	@NotNull
	private String emailId;
	@NotNull
	private Long orgId;
	@NotNull
	@Size(min = 8, max = 20)
	private String password;

	public LoginBean(String emailId, Long orgId, String password) {
		this.emailId = emailId;
		this.orgId = orgId;
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
