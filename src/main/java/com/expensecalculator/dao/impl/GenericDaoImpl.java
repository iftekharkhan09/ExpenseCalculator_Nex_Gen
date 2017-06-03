package com.expensecalculator.dao.impl;

import java.util.List;
import java.lang.reflect.ParameterizedType;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import com.expensecalculator.dao.GenericDao;
import com.expensecalculator.domain.Gender;
import com.expensecalculator.domain.Staff;

public class GenericDaoImpl<T> implements GenericDao<T>  {
	private static final String PERSISTENCE_UNIT_NAME = "expenseCalculator";
	@PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
	private static EntityManagerFactory factory;
	protected static EntityManager em;
	
	protected Class<T> domainClass;
	/** The domain object name. */
	protected String domainObjectName = null;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em=factory.createEntityManager();
		domainClass = (Class<T>) ((ParameterizedType) getClass()
		.getGenericSuperclass()).getActualTypeArguments()[0];
		Entity entityAnn = (Entity) domainClass.getAnnotation(Entity.class);
		if (entityAnn != null && !entityAnn.name().equals("")) {
			domainObjectName = entityAnn.name();
		} else {
			domainObjectName = domainClass.getSimpleName();
		}
	}
	
	public T create(T t) {
		this.em.persist(t);
		return t;
	}

	public void delete(Object id) {
		this.em.remove(id);
	}

	public T find(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	public T update(T t) {
		// TODO Auto-generated method stub
		return null;
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
