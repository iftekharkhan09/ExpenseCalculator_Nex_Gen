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
@Table(name="UNIT")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@NamedQueries({@NamedQuery(name="Unit.findAll()",query="select u from Unit u"),
			   @NamedQuery(name="Unit.findUnique()",query="select u from Unit u where u.id=:unitId"),
			   @NamedQuery(name="Unit.findByUnit()",query="select u from Unit u where u.description=:description")
})
public class Unit {
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