package com.expensecalculator.dao;

import java.util.List;
import com.expensecalculator.domain.Name;

public interface NameDao {
	Name findUnique(int id);
	List<Name> findAll();
	Name findByName(String firstName,String lastName);
	Name findByfirstName(String firstName);
	Name findByLastName(String lastName);
}
