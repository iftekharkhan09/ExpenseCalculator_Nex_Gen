package com.expensecalculator.dao;

import java.util.List;

import com.expensecalculator.domain.Organization;

public interface OrganizationDao {
	public Organization findUnique(int organizationId);
	public List<Organization> findAll(); 
	public Organization findByName(String organizationName);
}
