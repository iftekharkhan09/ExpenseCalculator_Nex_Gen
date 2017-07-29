package com.expensecalculator.domain;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="REASON")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@NamedQueries({
	@NamedQuery(name="Reason.findAll",query="select r from Reason r"),
	@NamedQuery(name="Reason.findUnique",query="select r.description from Reason r where r.id=:reasonId")
})
public class Reason {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
