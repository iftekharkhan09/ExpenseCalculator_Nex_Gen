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
@Table(name = "ORGANIZATION")
@NamedQueries({ @NamedQuery(name = "Organization.findAll", query = "select o from Organization o"),
		@NamedQuery(name = "Organization.findUnique", query = "select o from Organization o where o.id=:organizationId"),
		@NamedQuery(name = "Organization.findByName", query = "select o from Organization o where o.OrganizationName=:organizationName") })
public class Organization {
	public Organization() {
		super();
	}

	public Organization(String organizationName) {
		this.OrganizationName = organizationName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String OrganizationName;

	public String getOrganizationName() {
		return OrganizationName;
	}

	public void setOrganizationName(String organizationName) {
		OrganizationName = organizationName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return OrganizationName.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Organization organization = (Organization) obj;
		return (OrganizationName == organization.OrganizationName
				|| (OrganizationName != null && OrganizationName.equals(organization.getOrganizationName())));
	}
}
