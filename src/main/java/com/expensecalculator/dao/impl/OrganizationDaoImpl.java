package com.expensecalculator.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.expensecalculator.dao.OrganizationDao;
import com.expensecalculator.domain.Name;
import com.expensecalculator.domain.Organization;

public class OrganizationDaoImpl extends GenericDaoImpl<Organization> implements OrganizationDao {
	@Override
	public Organization findUnique(int organizationId) {
		TypedQuery<Organization> query = em.createNamedQuery(domainObjectName + ".findUnique", domainClass);
		query.setParameter("organizationId", organizationId);
		Organization organization = null;
		try {
			organization = query.getSingleResult();
		} catch (NoResultException e) {
			organization = null;
		}
		return organization;
	}

	@Override
	public List<Organization> findAll() {
		TypedQuery<Organization> query = em.createNamedQuery(domainObjectName + ".findAll", domainClass);
		List<Organization> organizationList = null;
		try {
			organizationList = query.getResultList();
		} catch (Exception e) {
			organizationList = null;
		}
		return organizationList;
	}

	@Override
	public Organization findByName(String organizationName) {
		TypedQuery<Organization> query = em.createNamedQuery(domainObjectName + ".findByName", domainClass);
		query.setParameter("organizationName", organizationName);
		Organization organization = null;
		try {
			organization = query.getSingleResult();
		} catch (NoResultException e) {
			organization = null;
		}
		return organization;
	}
	
}
