package com.expensecalculator.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.expensecalculator.dao.UserDao;
import com.expensecalculator.domain.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public User findUnique(String userName) {
		TypedQuery<User> query = em.createNamedQuery(domainObjectName + ".findUnique", domainClass);
		query.setParameter(1, userName);
		User user = null;
		try {
			user = query.getSingleResult();
		} catch (Exception e) {
			user = null;
		}
		return user;
	}

	public User findByUsernameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<User> findAllUsers() {
		TypedQuery<User> query = em.createNamedQuery(domainObjectName + ".findAll()", domainClass);
		List<User> users = null;
		try {
			users = query.getResultList();
		} catch (Exception e) {
			users = null;
		}
		return users;
	}
}
