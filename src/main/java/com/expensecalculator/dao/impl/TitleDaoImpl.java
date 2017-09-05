package com.expensecalculator.dao.impl;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Component;
import com.expensecalculator.dao.TitleDao;
import com.expensecalculator.domain.Title;

@Repository
@Component
public class TitleDaoImpl extends GenericDaoImpl<Title> implements TitleDao {
	public Title findUnique(int id) {
		TypedQuery<Title> query = em.createNamedQuery(domainObjectName + ".findUnique()", domainClass)
				.setHint("org.hibernate.cacheable", "true");
		query.setParameter("id", id);
		Title title = null;
		try {
			title = query.getSingleResult();
		} catch (NoResultException e) {
			title = null;
		}
		return title;
	}
	public List<Title> findAll() {
		TypedQuery<Title> query = em.createNamedQuery(domainObjectName + ".findAll()", domainClass)
				.setHint("org.hibernate.cacheable", "true");
		List<Title> titleList = null;
		try {
			titleList = query.getResultList();
		} catch (Exception e) {
			titleList = null;
		}
		return titleList;
	}
	public Title findByTitle(String title) {
		TypedQuery<Title> query = em.createNamedQuery(domainObjectName + ".findByTitle()", domainClass)
				.setHint("org.hibernate.cacheable", "true");
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