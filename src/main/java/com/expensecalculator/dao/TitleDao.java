package com.expensecalculator.dao;

import java.util.List;
import com.expensecalculator.domain.Title;

public interface TitleDao {
	public Title findUnique(int id);
	public List<Title> findAll(); 
	public Title findByTitle(String title);
}
