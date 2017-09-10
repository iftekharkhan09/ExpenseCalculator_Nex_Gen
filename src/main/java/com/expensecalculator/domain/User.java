package com.expensecalculator.domain;

import java.util.Date;
import javax.persistence.Cacheable;
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
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "USER")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@NamedQueries({ @NamedQuery(name = "User.findAll()", query = "select u from User u"),
		@NamedQuery(name = "User.findUnique()", query = "select u from User u where u.username=:username") })
public class User {
	@OneToOne
	@JoinColumn(name = "organization_id")
	private Organization organization;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "start_date")
	private Date startDate = new Date();
	@Column(name = "leaving_date")
	private Date leavingDate;
	@OneToOne
	@JoinColumn(name = "name_id")
	private Name name;
	@OneToOne
	@JoinColumn(name = "gender_id")
	private Gender gender;
	@Column(name = "mobile_no")
	private String mobileNo;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
}