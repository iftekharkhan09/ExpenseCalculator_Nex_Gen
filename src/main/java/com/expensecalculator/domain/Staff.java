package com.expensecalculator.domain;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STAFF")
@NamedQueries({ @NamedQuery(name = "Staff.findByUserName", query = "select s from Staff s where s.userName=:username") })
public class Staff {
	@OneToOne
	@JoinColumn(name = "organization_id")
	private Organization organizations;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "ip_address")
	private String ipAddress;
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "leaving_date")
	private Date leavingDate;
	@Column
	private char isBlocked;
	@Column(name = "unsuccessful_login_attempts")
	private int unsuccessfullLoginAttempts;
	@Column(name = "name_id")
	private int nameId;
	@Column(name = "is_admin")
	private char isAdmin;
	@Column
	private String email;
	@OneToOne
	@JoinColumn(name = "gender_id")
	private Gender gender;
	private Date lastLogin;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getLeavingDate() {
		return leavingDate;
	}

	public void setLeavingDate(Date leavingDate) {
		this.leavingDate = leavingDate;
	}

	public int getUnsuccessfullLoginAttempts() {
		return unsuccessfullLoginAttempts;
	}

	public void setUnsuccessfullLoginAttempts(int unsuccessfullLoginAttempts) {
		this.unsuccessfullLoginAttempts = unsuccessfullLoginAttempts;
	}

	public int getNameId() {
		return nameId;
	}

	public void setNameId(int nameId) {
		this.nameId = nameId;
	}

	public char getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(char isAdmin) {
		this.isAdmin = isAdmin;
	}

	public char getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(char isBlocked) {
		this.isBlocked = isBlocked;
	}
}