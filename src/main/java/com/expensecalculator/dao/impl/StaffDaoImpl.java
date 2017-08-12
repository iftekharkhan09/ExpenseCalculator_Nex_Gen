package com.expensecalculator.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.expensecalculator.dao.StaffDao;
import com.expensecalculator.domain.Staff;

@Repository
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
	public Staff findByUsernameAndPassword(String userName, String password) {
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
	public boolean addStaff(Staff staff) {
		create(staff);
		return true;
	}
}