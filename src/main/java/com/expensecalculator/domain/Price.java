package com.expensecalculator.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name="PRICE")
@NamedQueries({@NamedQuery(name="Price.findAll",query="select p from Price p"),
			   @NamedQuery(name="Price.findById",query="select p fromm Price p where p.id=:priceId")
})
public class Price {
	private Integer id;
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	String Description;
}