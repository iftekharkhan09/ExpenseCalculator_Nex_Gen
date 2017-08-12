package com.expensecalculator.domain;

import javax.annotation.Generated;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="USERROLES")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class UserRoles {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	@Column(name="user_role")
	private String roles;
}