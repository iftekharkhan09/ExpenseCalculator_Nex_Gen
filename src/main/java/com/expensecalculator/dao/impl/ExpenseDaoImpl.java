package com.expensecalculator.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import com.expensecalculator.dao.ExpenseDao;
import com.expensecalculator.domain.Expense;
import com.expensecalculator.ui.beans.ExpenseCreationBean;

public class ExpenseDaoImpl extends GenericDaoImpl<Expense> implements ExpenseDao {

	@Override
	public boolean addExpense(ExpenseCreationBean expenseCreationBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editExpense(ExpenseCreationBean expenseCreationBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteExpense(ExpenseCreationBean expenseCreationBean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Expense> findAll() {
		TypedQuery<Expense> query = em.createNamedQuery(domainObjectName + ".findAll", domainClass);
		List<Expense> expenses;
		try {
			expenses = query.getResultList();
		} catch (Exception e) {
			expenses = null;
		}
		return expenses;
	}

	@Override
	public Expense findUnique(int id) {
		TypedQuery<Expense> query = em.createNamedQuery(domainObjectName + ".findUnique", domainClass);
		query.setParameter("expenseId", id);
		Expense expense=null;
		try {
			expense = query.getSingleResult();
		} catch (Exception e) {
			expense = null;
		}
		return expense;
	}
}