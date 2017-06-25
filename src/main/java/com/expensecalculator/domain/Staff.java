package com.expensecalculator.domain;

import java.util.Date;

import javax.persistence.CascadeType;
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

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "STAFF")
@NamedQueries({ @NamedQuery(name = "Staff.findByUserName", query = "select s from Staff s where s.userName=:username"),
		@NamedQuery(name = "Staff.findByUsernameAndPass", query = "select s from Staff s where s.userName=:username and s.password=:password") })
public class Staff {
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "organization_id")
	private Organization organization;
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
	private Date startDate = new Date();
	@Column(name = "leaving_date")
	private Date leavingDate;
	@Column(name = "is_blocked", columnDefinition = "char(1) default 'N'")
	private char isBlocked;
	@Column(name = "unsuccessful_login_attempts", columnDefinition = "integer default '0'")
	private int unsuccessfullLoginAttempts;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "name_id")
	private Name name;
	@Column(name = "is_admin", columnDefinition = "char(1) default 'N'")
	private char isAdmin;
	@Column
	private String email;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "gender_id")
	private Gender gender;
	@Column(name = "last_login")
	private Date lastLogin;
	@Column(name = "mobile_no")
	private String mobileNo;

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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
}