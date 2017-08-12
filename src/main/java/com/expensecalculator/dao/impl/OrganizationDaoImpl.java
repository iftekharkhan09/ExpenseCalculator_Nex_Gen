package com.expensecalculator.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;
=======

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

>>>>>>> refs/remotes/origin/DevBranch
import com.expensecalculator.dao.OrganizationDao;
import com.expensecalculator.domain.Organization;

<<<<<<< HEAD
@Repository
=======
@Component
@Transactional
>>>>>>> refs/remotes/origin/DevBranch
public class OrganizationDaoImpl extends GenericDaoImpl<Organization> implements OrganizationDao {
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
