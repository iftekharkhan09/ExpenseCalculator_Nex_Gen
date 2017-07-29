package com.expensecalculator.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import com.expensecalculator.dao.UnitDao;
import com.expensecalculator.domain.Unit;

public class UnitDaoImpl extends GenericDaoImpl<Unit> implements UnitDao {

	@Override
	public Unit findUnique(int id) {
		TypedQuery<Unit> query = em.createNamedQuery(domainObjectName + ".findUnique", domainClass);
		query.setParameter("id", id);
		Unit unit = null;
		try {
			unit = query.getSingleResult();
		} catch (NoResultException e) {
			unit = null;
		}
		return unit;
	}

	@Override
	public List<Unit> findAll() {
		TypedQuery<Unit> query = em.createNamedQuery(domainObjectName + ".findUnique", domainClass);
		List<Unit> units = null;
		try {
			units = query.getResultList();
		} catch (Exception e) {
			units = null;
		}
		return units;
	}

	@Override
	public Unit findByUnit(String unitDescription) {
		TypedQuery<Unit> query = em.createNamedQuery(domainObjectName + ".findUnique", domainClass);
		query.setParameter("description", unitDescription);
		Unit unit = null;
		try {
			unit = query.getSingleResult();
		} catch (NoResultException e) {
			unit = null;
		}
		return unit;
	}
}