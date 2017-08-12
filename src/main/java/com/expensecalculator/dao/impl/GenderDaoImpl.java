package com.expensecalculator.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.expensecalculator.dao.GenderDao;
import com.expensecalculator.domain.Gender;

@Repository
public class GenderDaoImpl extends GenericDaoImpl<Gender> implements GenderDao {
	public Gender findUnique(int id) {
		TypedQuery<Gender> query = em.createNamedQuery(domainObjectName + ".findUnique", domainClass)
				.setHint("org.hibernate.cacheable", "true");
		query.setParameter("id", id);
		Gender gender = null;
		try {
			gender = query.getSingleResult();
		} catch (NoResultException e) {
			gender = null;
		}
		return gender;
	}
	public List<Gender> findAll() {
		TypedQuery<Gender> query = em.createNamedQuery(domainObjectName + ".findAll", domainClass)
				.setHint("org.hibernate.cacheable", "true");
		List<Gender> genderList = null;
		try {
			genderList = query.getResultList();
		} catch (Exception e) {
			genderList = null;
		}
		return genderList;
	}
	public Gender findByGender(String gender) {
		TypedQuery<Gender> query = em.createNamedQuery(domainObjectName + ".findByGender", domainClass)
				.setHint("org.hibernate.cacheable", "true");
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