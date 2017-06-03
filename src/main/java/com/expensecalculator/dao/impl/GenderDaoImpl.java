package com.expensecalculator.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import com.expensecalculator.dao.GenderDao;
import com.expensecalculator.domain.Gender;

public class GenderDaoImpl extends GenericDaoImpl<Gender> implements GenderDao {
	@Override
	public Gender findUnique(int id) {
		TypedQuery<Gender> query = em.createNamedQuery(domainObjectName + ".findUnique", domainClass);
		query.setParameter("id", id);
		Gender gender = null;
		try {
			gender = query.getSingleResult();
		} catch (NoResultException e) {
			gender = null;
		}
		return gender;
	}

	@Override
	public List<Gender> findAll() {
		TypedQuery<Gender> query = em.createNamedQuery(domainObjectName + ".findAll", domainClass);
		List<Gender> genderList = null;
		try {
			genderList = query.getResultList();
		} catch (Exception e) {
			genderList = null;
		}
		return genderList;
	}

	@Override
	public Gender findByGender(String gender) {
		TypedQuery<Gender> query = em.createNamedQuery(domainObjectName + ".findByGender", domainClass);
		query.setParameter("gender", gender);
		Gender genderDetail = null;
		try {
			genderDetail = query.getSingleResult();
		} catch (NoResultException e) {
			genderDetail = null;
		}
		return genderDetail;
	}
}
