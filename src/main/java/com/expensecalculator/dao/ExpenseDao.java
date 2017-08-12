package com.expensecalculator.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.expensecalculator.domain.Expense;
import com.expensecalculator.ui.beans.ExpenseCreationBean;

@Repository
public interface ExpenseDao {
	boolean addExpense(ExpenseCreationBean expenseCreationBean);

	boolean editExpense(ExpenseCreationBean expenseCreationBean);

	boolean deleteExpense(ExpenseCreationBean expenseCreationBean);

	List<Expense> findAll();

	Expense findUnique(int id);
}
