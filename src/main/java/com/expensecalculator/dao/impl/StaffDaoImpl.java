package com.expensecalculator.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.expensecalculator.dao.StaffDao;
import com.expensecalculator.domain.Staff;

public class StaffDaoImpl extends GenericDaoImpl<Staff> implements StaffDao {
	public Staff findUnique(String userName) {
		TypedQuery<Staff> query = em.createNamedQuery(domainObjectName + ".findByUserName", domainClass);
		query.setParameter("username", userName);
		Staff staff = null;
		try {
			staff = query.getSingleResult();
		} catch (NoResultException e) {
			staff = null;
		}
		return staff;
	}

	@Override
	public Staff authenticateStaff(String userName, String password) {
		TypedQuery<Staff> query = em.createNamedQuery(domainObjectName + ".findByUserNameAndPass", domainClass);
		query.setParameter("username", userName);
		query.setParameter("password", password);
		Staff staff = null;
		try {
			staff = query.getSingleResult();
		} catch (NoResultException e) {
			staff = null;
		}
		return staff;
	}
}