package com.expensecalculator.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import com.expensecalculator.dao.NameDao;
import com.expensecalculator.domain.Name;

public class NameDaoImpl extends GenericDaoImpl<Name> implements NameDao{
	@Override
	public List<Name> findAll() {
		TypedQuery<Name> query = em.createNamedQuery(domainObjectName + ".findAll", domainClass);
		List<Name> nameList = null;
		try {
			nameList = query.getResultList();
		} catch (Exception e) {
			nameList = null;
		}
		return nameList;
	}


	@Override
	public Name findUnique(int id) {
		TypedQuery<Name> query = em.createNamedQuery(domainObjectName + ".findUnique", domainClass);
		query.setParameter("id", id);
		Name name = null;
		try {
			name = query.getSingleResult();
		} catch (NoResultException e) {
			name = null;
		}
		return name;
	}

	@Override
	public boolean createName(Name name) {
		create(name);
		return true;
	}

	@Override
	public Name findByName(String firstName, String lastName) {
		TypedQuery<Name> query = em.createNamedQuery(domainObjectName + ".findByName", domainClass);
		query.setParameter("firstName", firstName);
		query.setParameter("lastName", lastName);
		Name name = null;
		try {
			name = query.getSingleResult();
		} catch (NoResultException e) {
			name = null;
		}
		return name;
	}


	@Override
	public Name findByfirstName(String firstName) {
		TypedQuery<Name> query = em.createNamedQuery(domainObjectName + ".findByFirstName", domainClass);
		query.setParameter("firstName", firstName);
		Name name = null;
		try {
			name = query.getSingleResult();
		} catch (NoResultException e) {
			name = null;
		}
		return name;
	}


	@Override
	public Name findByLastName(String lastName) {
		TypedQuery<Name> query = em.createNamedQuery(domainObjectName + ".findByLastName", domainClass);
		query.setParameter("firstName", lastName);
		Name name = null;
		try {
			name = query.getSingleResult();
		} catch (NoResultException e) {
			name = null;
		}
		return name;
	}
}
