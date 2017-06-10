package com.expensecalculator.dao;
import java.util.List;

import org.springframework.stereotype.Service;
import com.expensecalculator.domain.Title;

@Service
public interface TitleDao {
	public Title findUnique(int id);
	public List<Title> findAll(); 
	public Title findByTitle(String title);
}
