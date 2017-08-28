package com.expensecalculator.service;

import com.expensecalculator.ui.beans.ExpenseCreationBean;

public interface ExpenseService {
	boolean createExpense(ExpenseCreationBean expenseCreationBean);
}
