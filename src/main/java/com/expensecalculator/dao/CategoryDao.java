package com.expensecalculator.dao;

import java.util.List;

import com.expensecalculator.domain.Category;

public interface CategoryDao {
	List<Category> findAll();
	Category findUnique(int id);
	Category findUnique(String description);
}
