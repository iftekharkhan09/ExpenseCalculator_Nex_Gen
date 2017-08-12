package com.expensecalculator.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.expensecalculator.domain.Unit;

@Repository
public interface UnitDao {
	public Unit findUnique(int id);
	public List<Unit> findAll();
	public Unit findByUnit(String unitDescription);
}
