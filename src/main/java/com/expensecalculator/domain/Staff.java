package com.expensecalculator.domain;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="STAFF")
public class Staff {
	@OneToOne
	@JoinColumn(name="organization_id")
	private Organization organizations;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int staff_id;
	@Column
	private String ipaddress;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private Date start_date;
	@Column
	private Date leaving_date;
	@Column
	private char blocked;
	@Column
	private int unsuccessfull_login_attempts;
	@Column
	private int name_id;
	@Column
	private char is_admin;
	@Column
	private String email;
	@OneToOne
	@JoinColumn(name="gender_id")
	private Gender gender;
	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public char getBlocked() {
		return blocked;
	}

	public void setBlocked(char blocked) {
		this.blocked = blocked;
	}

	public int getUnsuccessfull_login_attempts() {
		return unsuccessfull_login_attempts;
	}

	public void setUnsuccessfull_login_attempts(int unsuccessfull_login_attempts) {
		this.unsuccessfull_login_attempts = unsuccessfull_login_attempts;
	}

	public int getName_id() {
		return name_id;
	}

	public void setName_id(int name_id) {
		this.name_id = name_id;
	}

	public char getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(char is_admin) {
		this.is_admin = is_admin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}