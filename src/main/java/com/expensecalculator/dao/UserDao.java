package com.expensecalculator.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.expensecalculator.domain.User;

public interface UserDao {
	List<User> findAllUsers();

	User findUnique(String userName);

	User findByUsernameAndPassword(String userName, String password);

	boolean addUser(User user);
}
