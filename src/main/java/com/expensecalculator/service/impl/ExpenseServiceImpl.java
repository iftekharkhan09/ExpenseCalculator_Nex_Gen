package com.expensecalculator.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensecalculator.dao.ExpenseDao;
import com.expensecalculator.dao.impl.ExpenseDaoImpl;
import com.expensecalculator.domain.Expense;
import com.expensecalculator.domain.User;
import com.expensecalculator.service.ExpenseService;
import com.expensecalculator.ui.beans.ExpenseCreationBean;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	@Autowired 
	private Expense expense;

	public boolean createExpense(ExpenseCreationBean expenseCreationBean) {
		Expense expense=new Expense();
		expense.setAmountPaidBy(expenseCreationBean.getAmountPaidBy());
		expense.setComments(expenseCreationBean.getComments());
		expense.setDateOfPurchase(expenseCreationBean.getDateOfPurchase());
		expense.setItem(expenseCreationBean.getItemName());
		expense.setQuantityPurchased(expenseCreationBean.getQuantityPurchased());
		expense.setTotalPrice(expenseCreationBean.getTotalAmt());
		User u = null;
		expense.setUpdatedBy(u);
		expense.setUpdatedDatetime(new Date());
		new ExpenseDaoImpl().create(expense);
		return true;
	}
}
