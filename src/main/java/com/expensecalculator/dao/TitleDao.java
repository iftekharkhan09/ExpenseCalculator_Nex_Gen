package com.expensecalculator.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.expensecalculator.domain.Title;

@Repository
public interface TitleDao {
	public Title findUnique(int id);
	public List<Title> findAll(); 
	public Title findByTitle(String title);
}
