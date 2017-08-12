package com.expensecalculator.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.expensecalculator.domain.Gender;

@Repository
public interface GenderDao {
	public Gender findUnique(int id);
	public List<Gender> findAll(); 
	public Gender findByGender(String gender);
}