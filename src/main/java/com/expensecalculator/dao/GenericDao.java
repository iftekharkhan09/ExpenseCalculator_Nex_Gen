package com.expensecalculator.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface GenericDao<T> {
	T create(T t);
	void delete(Object id);
	T find(Object id);
	T update(T t);
	long countAll(Map<String, Object> params);
	List<T> findAll();
	void createAll(List<T> list);
	int deleteAll();
}
