package com.expensecalculator.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.expensecalculator.dao.CategoryDao;
import com.expensecalculator.domain.Category;

@Repository
public class CategoryDaoImpl extends GenericDaoImpl<Category> implements CategoryDao {
	
	public List<Category> findAll() {
		TypedQuery<Category> query = em.createNamedQuery(domainObjectName + ".findAll()", domainClass);
		List<Category> categoryList = null;
		try {
			categoryList = query.getResultList();
		} catch (Exception e) {
			categoryList = null;
		}
		return categoryList;
	}

	public Category findUnique(int id) {
		TypedQuery<Category> query = em.createNamedQuery(domainObjectName + ".findUniqueById()", domainClass);
		query.setParameter("id", id);
		Category category = null;
		try {
			category = query.getSingleResult();
		} catch (Exception e) {
			category = null;
		}
		return category;
	}

	public Category findUnique(String description) {
		TypedQuery<Category> query = em.createNamedQuery(domainObjectName + ".findUniqueByDescription()", domainClass);
		query.setParameter("description", description);
		Category category = null;
		try {
			category = query.getSingleResult();
		} catch (Exception e) {
			category = null;
		}
		return category;
	}
}
