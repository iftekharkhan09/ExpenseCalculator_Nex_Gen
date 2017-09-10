package com.expensecalculator.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="STAFF_ORGANIZATION_ROLE")
@NamedQueries({ @NamedQuery(name = "findRoles()", 
				query = "select so from StaffOrganization so where so.organization.id =:organizationId and so.staff.id =:staffId") })
public class StaffOrganization {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name="staff_id")
	private Staff staff;
	@OneToOne
	@JoinColumn(name="organization_id")
	private Organization organization;
	@OneToOne
	@JoinColumn(name="staff_organization_Role_id")
	private StaffRoles staffRoles;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public StaffRoles getStaffRoles() {
		return staffRoles;
	}
	public void setStaffRoles(StaffRoles staffRoles) {
		this.staffRoles = staffRoles;
	}

}
