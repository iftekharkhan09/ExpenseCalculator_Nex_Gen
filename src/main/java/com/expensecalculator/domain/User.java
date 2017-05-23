package com.expensecalculator.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="USER")
public class User {
	@OneToOne
	@JoinColumn(name="Organization_id")
	private Organization organization;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_id;
	@Column(name="username")
	private String username;
	@Column(name="email")
	private String email;
	@Column(name="start_date")
	private Date start_date;
	@Column(name="leaving_date")
	private Date leaving_date;
	@OneToOne
	@JoinColumn(name="name_id")
	private Name name;
	@OneToOne
	@JoinColumn(name="gender_id")
	private Gender gender;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getLeaving_date() {
		return leaving_date;
	}

	public void setLeaving_date(Date leaving_date) {
		this.leaving_date = leaving_date;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
}