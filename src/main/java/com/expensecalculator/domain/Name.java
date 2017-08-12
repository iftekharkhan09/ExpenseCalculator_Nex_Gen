package com.expensecalculator.domain;

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
import org.springframework.stereotype.Component;

@Entity
@Table(name = "NAME")
@Cacheable
@Component
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@NamedQueries({ @NamedQuery(name = "Name.findAll", query = "select n from Name n"),
		@NamedQuery(name = "Name.findByFirstName", query = "select n from Name n where n.firstName=:firstName"),
		@NamedQuery(name = "Name.findByLastName", query = "select n from Name n where n.lastName=:lastName"),
		@NamedQuery(name = "Name.findByName", query = "select n from Name n where n.firstName=:firstName"
				+ " AND n.lastName=:lastName"),
		@NamedQuery(name = "Name.findUnique", query = "select n from Name n where n.id=:id") })
public class Name {
	public Name() {
		super();
	}

	public Name(String firstName, String lastName, Title title) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@OneToOne
	@JoinColumn(name = "title_id")
	private Title title;

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		int primeNumber = 17;
		int titleId = title.getId();
		return (primeNumber * firstName.hashCode() + lastName.hashCode()) + titleId;

	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Name name = (Name) obj;
		return (firstName == name.firstName || (firstName != null && firstName.equals(name.getFirstName()))
				&& (lastName == name.lastName || (lastName != null && lastName.equals(name.getLastName())))
				&& (this.title.getId() == name.title.getId()));
	}
}
