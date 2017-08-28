package com.expensecalculator.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.stereotype.Component;

@Component
@NamedQueries({ @NamedQuery(name = "Expense.findAll()", query = "select e from Expense e"), 
			@NamedQuery(name = "Expense.findUnique()", query = "select e from Expense e where e.id=:expenseId") })
@Entity
@Table(name = "EXPENSE")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@OneToOne
//	@JoinColumn(name = "item_id")
//	private Item item;
	@Column(name="item")
	private String item;
	@OneToOne
	@JoinColumn(name = "reason_id")
	private Reason reason;
	@Temporal(TemporalType.DATE)
	private java.util.Date dateOfPurchase;
	@Temporal(TemporalType.DATE)
	private Date updatedDatetime;
	@OneToMany
	@JoinTable(name = "EXPENSE_EXCLUDED_USERS", joinColumns = @JoinColumn(name = "expense_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> excludedUsers;
	@Column(name = "quantity_purchased")
	private double quantityPurchased;
	@OneToOne
	@JoinColumn(name = "amount_paid_by")
	private User amountPaidBy;
	@Column(name = "total_price")
	private double totalPrice;
	@OneToOne
	@JoinColumn(name = "updated_by")
	private User updatedBy;
	@Column(name = "comments")
	private String comments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public Item getItem() {
//		return item;
//	}
//	public void setItem(Item item) {
//		this.item = item;
//	}
	public Reason getReason() {
		return reason;
	}
	public void setReason(Reason reason) {
		this.reason = reason;
	}
	public java.util.Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(java.util.Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public Date getUpdatedDatetime() {
		return updatedDatetime;
	}
	public void setUpdatedDatetime(Date updatedDatetime) {
		this.updatedDatetime = updatedDatetime;
	}
	public double getQuantityPurchased() {
		return quantityPurchased;
	}
	public void setQuantityPurchased(double quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public User getAmountPaidBy() {
		return amountPaidBy;
	}
	public void setAmountPaidBy(User amountPaidBy) {
		this.amountPaidBy = amountPaidBy;
	}
	public User getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public void setItem(String item) {
		this.item = item;
	}
}