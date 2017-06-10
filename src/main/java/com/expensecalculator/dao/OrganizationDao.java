package com.expensecalculator.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.expensecalculator.domain.Organization;

@Repository
public interface OrganizationDao {
	Organization findUnique(int organizationId);
	List<Organization> findAll(); 
	Organization findByName(String organizationName);
}
