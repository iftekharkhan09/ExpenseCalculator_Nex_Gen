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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "EXPENSE")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name = "item_id")
	private Item item;
	@OneToOne
	@JoinColumn(name = "reason_id")
	private Reason reason;
	@Temporal(TemporalType.DATE)
	private java.util.Date dateOfPurchase;
	@Temporal(TemporalType.DATE)
	private Date updatedDatetime;
	@OneToMany
	@JoinTable(name = "expense_excluded_users", joinColumns = @JoinColumn(name = "expense_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
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
}