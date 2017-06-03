package com.expensecalculator.service.impl;

import java.util.Date;

import com.expensecalculator.dao.impl.GenderDaoImpl;
import com.expensecalculator.dao.impl.GenericDaoImpl;
import com.expensecalculator.dao.impl.OrganizationDaoImpl;
import com.expensecalculator.dao.impl.StaffDaoImpl;
import com.expensecalculator.dao.impl.TitleDaoImpl;
import com.expensecalculator.domain.Gender;
import com.expensecalculator.domain.Name;
import com.expensecalculator.domain.Organization;
import com.expensecalculator.domain.Staff;
import com.expensecalculator.domain.Title;
import com.expensecalculator.service.StaffService;
import com.expensecalculator.ui.beans.LoginBean;
import com.expensecalculator.ui.beans.StaffRegistrationBean;

public class StaffServiceImpl implements StaffService {
	@Override
	public Staff authenticateStaff(LoginBean loginBean) {
		Staff staff = new StaffDaoImpl().findUnique(loginBean.getUserName());
		if (staff != null)
			return staff;
		return null;
	}

	@SuppressWarnings("deprecation")
	public boolean createStaff(StaffRegistrationBean staffRegistrationBean) {
		String firstName = "Sunny";
		String lastName = "Babu";
		Title title = new TitleDaoImpl().findById(1);
		Gender gender = new GenderDaoImpl().findById(1);
		Name name = new Name(firstName, lastName, title);
		Staff staff = new Staff();
		//staff.setEmail(staffRegistrationBean.getEmail());
		staff.setEmail("iakhan@gamil.com");
		staff.setIpAddress("1.2.3.4");
		staff.setIsAdmin('Y');
		staff.setIsBlocked('N');
		staff.setLastLogin(null);
		staff.setLeavingDate(null);
		staff.setName(name);
		//staff.setPassword(staffRegistrationBean.getPassword());
		staff.setPassword("Sunny123");
		staff.setStartDate(new java.sql.Date(2017, 03, 31));
		staff.setUnsuccessfullLoginAttempts(1);
		//staff.setUserName(staffRegistrationBean.getUserName());
		staff.setUserName("iakhan");
		staff.setGender(gender);
		//Organization organization = new OrganizationDaoImpl().findUnique(staffRegistrationBean.getOrganization());
		Organization organization = new OrganizationDaoImpl().findByName("ACCENTURE");
		staff.setOrganization(organization);
		new StaffDaoImpl().create(staff);
		//System.out.println(staff1.getIpAddress());
		return true;
	}
	public static void main(String[] args) {
		new StaffServiceImpl().createStaff(null);
	}
}
