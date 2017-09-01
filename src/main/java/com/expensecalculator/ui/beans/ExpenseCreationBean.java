package com.expensecalculator.ui.beans;

import java.sql.Date;
import java.util.Set;

public class ExpenseCreationBean {
	private String amountPaidBy;
	private double amountPaid;
	private String category;
	private String unit;
	private double totalAmt;
	private Date dateOfPurchase;
	private String itemName;
	private Set<String> excludedUsers;
	private String comments;
	private double quantityPurchased;
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getAmountPaidBy() {
		return amountPaidBy;
	}
	public void setAmountPaidBy(String amountPaidBy) {
		this.amountPaidBy = amountPaidBy;
	}
	public Set<String> getExcludedUsers() {
		return excludedUsers;
	}
	public void setExcludedUsers(Set<String> excludedUsers) {
		this.excludedUsers = excludedUsers;
	}
}
