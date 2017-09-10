package com.expensecalculator.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.expensecalculator.dao.StaffDao;
import com.expensecalculator.domain.Staff;

@Repository
public class StaffDaoImpl extends GenericDaoImpl<Staff> implements StaffDao {
	public Staff findByEmailAndPassword(String emailId, String password) {
		TypedQuery<Staff> query = em.createNamedQuery(domainObjectName + ".findByUserNameAndPass()", domainClass);
		query.setParameter("email", emailId);
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
	public Staff findByEmail(String emailId) {
		TypedQuery<Staff> query=em.createNamedQuery(domainObjectName+".findByEmail()",domainClass);
		query.setParameter("emailId", emailId);
		Staff staff=null;
		try {
			staff=query.getSingleResult();
		}
		catch (Exception e) {
			staff=null;
		}
		return staff;
	}
}