package com.expensecalculator.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "GENDER")
@NamedQueries({ @NamedQuery(name = "Gender.findAll", query = "select g from Gender g"),
				@NamedQuery(name = "Gender.findUnique", query = "select g from Gender g where g.id=:id"),
				@NamedQuery(name = "Gender.findByGender", query = "select g from Gender g where g.gender=:gender")
})
public class Gender {
	public Gender() {
	}
	public Gender(int id, String gender) {
		this.id = id;
		this.gender = gender;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String gender;

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
