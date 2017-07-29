package com.expensecalculator.dao;

import java.util.List;

import com.expensecalculator.domain.Unit;

public interface UnitDao {
	public Unit findUnique(int id);
	public List<Unit> findAll();
	public Unit findByUnit(String unitDescription);
}
