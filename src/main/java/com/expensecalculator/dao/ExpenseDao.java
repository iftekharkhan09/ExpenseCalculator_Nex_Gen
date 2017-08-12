package com.expensecalculator.dao;

import java.util.List;
import com.expensecalculator.domain.Expense;
import com.expensecalculator.ui.beans.ExpenseCreationBean;

public interface ExpenseDao {
	boolean addExpense(ExpenseCreationBean expenseCreationBean);

	boolean editExpense(ExpenseCreationBean expenseCreationBean);

	boolean deleteExpense(ExpenseCreationBean expenseCreationBean);

	List<Expense> findAll();

	Expense findUnique(int id);
}
