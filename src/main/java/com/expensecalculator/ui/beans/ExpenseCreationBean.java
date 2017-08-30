package com.expensecalculator.ui.beans;

import java.sql.Date;
import java.util.List;
import java.util.Set;
import com.expensecalculator.domain.Category;
import com.expensecalculator.domain.Unit;
import com.expensecalculator.domain.User;

public class ExpenseCreationBean {
	private User amountPaidBy;
	private double amountPaid;
	private Category category;
	private Unit unit;
	private double totalAmt;
	private Date dateOfPurchase;
	private String itemName;
	private Set<User> excludedUsers;
	private String comments;
	private double quantityPurchased;
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Set<User> getExcludedUsers() {
		return excludedUsers;
	}
	public void setExcludedUsers(Set<User> excludedUsers) {
		this.excludedUsers = excludedUsers;
	}
	public User getAmountPaidBy() {
		return amountPaidBy;
	}
	public void setAmountPaidBy(User amountPaidBy) {
		this.amountPaidBy = amountPaidBy;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public double getQuantityPurchased() {
		return quantityPurchased;
	}
	public void setQuantityPurchased(double quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
