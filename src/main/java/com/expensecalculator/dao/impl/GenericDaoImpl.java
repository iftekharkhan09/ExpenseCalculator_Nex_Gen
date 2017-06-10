package com.expensecalculator.dao.impl;

import java.util.List;
import java.lang.reflect.ParameterizedType;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.expensecalculator.dao.GenericDao;

@Component
public class GenericDaoImpl<T> implements GenericDao<T> {
	private static final String PERSISTENCE_UNIT_NAME = "expenseCalculator";
	@PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
	private static EntityManagerFactory factory;
	protected static EntityManager em;
	protected EntityTransaction etr;

	protected Class<T> domainClass;
	/** The domain object name. */
	protected String domainObjectName = null;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = factory.createEntityManager();
		domainClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		Entity entityAnn = (Entity) domainClass.getAnnotation(Entity.class);
		if (entityAnn != null && !entityAnn.name().equals("")) {
			domainObjectName = entityAnn.name();
		} else {
			domainObjectName = domainClass.getSimpleName();
		}
	}

	public T create(T t) {
		etr = em.getTransaction();
		etr.begin();
		em.persist(t);
		etr.commit();
		return t;
	}

	public void delete(Object id) {
		em.remove(id);
	}

	public T find(Object id) {
		return em.find(domainClass,id);
	}

	public T update(T t) {
		etr = em.getTransaction();
		etr.begin();
		em.merge(t);
		etr.commit();
		return t;
	}

	public long countAll(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void createAll(List<T> list) {
		// TODO Auto-generated method stub

	}

	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}
}
