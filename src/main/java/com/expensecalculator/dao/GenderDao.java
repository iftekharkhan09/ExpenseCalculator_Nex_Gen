package com.expensecalculator.dao;

import java.util.List;
import com.expensecalculator.domain.Gender;

public interface GenderDao {
	public Gender findUnique(int id);
	public List<Gender> findAll(); 
	public Gender findByGender(String gender);
}