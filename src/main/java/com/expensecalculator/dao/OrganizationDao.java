package com.expensecalculator.dao;

import java.util.List;
import org.springframework.stereotype.Service;
import com.expensecalculator.domain.Organization;

public interface OrganizationDao {
	Organization findUnique(int organizationId);
	List<Organization> findAll(); 
	Organization findByName(String organizationName);
}
