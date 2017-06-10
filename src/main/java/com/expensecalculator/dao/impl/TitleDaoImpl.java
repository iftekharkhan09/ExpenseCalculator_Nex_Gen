package com.expensecalculator.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.expensecalculator.dao.TitleDao;
import com.expensecalculator.domain.Title;

@Component
public class TitleDaoImpl extends GenericDaoImpl<Title> implements TitleDao{
	@Override
	public Title findUnique(int id) {
		TypedQuery<Title> query = em.createNamedQuery(domainObjectName + ".findUnique", domainClass);
		query.setParameter("id", id);
		Title title = null;
		try {
			title = query.getSingleResult();
		} catch (NoResultException e) {
			title = null;
		}
		return title;
	}

	@Override
	public List<Title> findAll() {
		TypedQuery<Title> query = em.createNamedQuery(domainObjectName + ".findAll", domainClass);
		List<Title> titleList = null;
		try {
			titleList = query.getResultList();
		} catch (Exception e) {
			titleList = null;
		}
		return titleList;
	}

	@Override
	public Title findByTitle(String title) {
		TypedQuery<Title> query = em.createNamedQuery(domainObjectName + ".findByTitle", domainClass);
		query.setParameter("title", title);
		Title titleDetail = null;
		try {
			titleDetail = query.getSingleResult();
		} catch (NoResultException e) {
			titleDetail = null;
		}
		return titleDetail;
	}

}
