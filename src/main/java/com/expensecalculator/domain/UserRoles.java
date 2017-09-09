package com.expensecalculator.domain;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "USER_ROLES")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class UserRoles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public enum Roles {
		USER(100), ADMIN(200);
		private int values;

		Roles(int values) {
			this.values = values;
		}

		public int getValues() {
			return values;
		}
	}

	@Column
	@Enumerated(EnumType.ORDINAL)
	private Roles roles;
}