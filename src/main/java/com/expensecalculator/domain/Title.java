package com.expensecalculator.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TITLE")
@NamedQueries({
	@NamedQuery(name="Title.findAll",query="select t from Title t"),
	@NamedQuery(name="Title.findUnique",query="select t from Title t where t.id=:titleId"),
	@NamedQuery(name="Title.findById",query="select t from Title t where t.id=:id")
})
public class Title {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String title;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
