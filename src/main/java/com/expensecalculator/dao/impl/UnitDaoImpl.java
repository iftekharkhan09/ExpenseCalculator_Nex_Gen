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
import com.expensecalculator.dao.UnitDao;
import com.expensecalculator.domain.Unit;

<<<<<<< HEAD
@Repository
=======
@Component
@Transactional
>>>>>>> refs/remotes/origin/DevBranch
public class UnitDaoImpl extends GenericDaoImpl<Unit> implements UnitDao {
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