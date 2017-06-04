package com.expensecalculator.service.impl;

import java.util.Date;
import com.expensecalculator.dao.impl.GenderDaoImpl;
import com.expensecalculator.dao.impl.NameDaoImpl;
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
import com.expensecalculator.utils.ObjectComparator;

public class StaffServiceImpl implements StaffService {
	@Override
	public Staff authenticateStaff(LoginBean loginBean) {
		Staff staff = new StaffDaoImpl().findUnique(loginBean.getUserName());
		if (staff != null && staff.getUserName().equals(loginBean.getUserName())
				&& staff.getPassword().equals(loginBean.getPassword()))
			return staff;
		return null;
	}

	public boolean createStaff(StaffRegistrationBean staffRegistrationBean) {
		Staff staff = new Staff();
		Title title = new TitleDaoImpl().findUnique(1);
		Name inputName=new Name(staffRegistrationBean.getFirstName(),staffRegistrationBean.getLastName(),title);
		Name name = new Name();
		name=new ObjectComparator().isNameAlreadyDefined(inputName);
		if(null!=name) {
			//do Nothing..
		} else {
			name=new NameDaoImpl().create(inputName);
		}
		 Gender gender=new GenderDaoImpl().findUnique(1); 
		 staff.setEmail(staffRegistrationBean.getEmail());
		 staff.setName(name);	
		 staff.setIpAddress("1.2.3.4");
		 staff.setIsAdmin('Y');
		 staff.setLastLogin(null); 
		 staff.setLeavingDate(null);
		 staff.setPassword(staffRegistrationBean.getPassword());
		 staff.setStartDate(new Date());
		 staff.setUserName(staffRegistrationBean.getUserName());
		 staff.setGender(gender);
		 Organization inputOrganization=new Organization(staffRegistrationBean.getOrganization());
		 Organization organization=new Organization();
		 organization=new ObjectComparator().isOrganizationAlreadyDefined(inputOrganization);
		 if(null!=organization) {
				//do Nothing..
			} else {
				organization=new OrganizationDaoImpl().create(inputOrganization);
			}
		 staff.setOrganization(organization);
		 staff.setMobileNo(staffRegistrationBean.getPhoneNo());
		 new StaffDaoImpl().create(staff);

		return true;
	}

	public static void main(String[] args) {
		new StaffServiceImpl().createStaff(null);
	}
}
