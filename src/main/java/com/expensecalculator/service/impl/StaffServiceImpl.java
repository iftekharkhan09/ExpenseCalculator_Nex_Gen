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
import com.expensecalculator.utils.MachineDetails;
import com.expensecalculator.utils.ObjectComparator;

public class StaffServiceImpl implements StaffService {
	@Override
	public Staff authenticateStaff(LoginBean loginBean) {
		Staff staff = new StaffDaoImpl().findUnique(loginBean.getUserName());
		if (staff.getIsBlocked() == 'N' && staff != null && staff.getUserName().equals(loginBean.getUserName())
				&& staff.getPassword().equals(loginBean.getPassword())) {
			staff.setLastLogin(new Date());
			new StaffDaoImpl().update(staff);
			return staff;
		} else {
			updateUnsuccessfulAttempts(staff);
		}
		return null;
	}

	@Override
	public boolean createStaff(StaffRegistrationBean staffRegistrationBean) {
		Staff staff = new Staff();
		Title title = new TitleDaoImpl().findUnique(1);
		Name inputName = new Name(staffRegistrationBean.getFirstName(), staffRegistrationBean.getLastName(), title);
		Name name = new Name();
		name = new ObjectComparator().isNameAlreadyDefined(inputName);
		if (null != name) {
			// do Nothing..
		} else {
			name = new NameDaoImpl().create(inputName);
		}
		Gender gender = new GenderDaoImpl().findUnique(1);
		staff.setEmail(staffRegistrationBean.getEmail());
		staff.setName(name);
		staff.setIpAddress(new MachineDetails().getIPAddress());
		staff.setIsAdmin('Y');
		staff.setIsBlocked('N');
		staff.setLastLogin(null);
		staff.setLeavingDate(null);
		staff.setPassword(staffRegistrationBean.getPassword());
		staff.setStartDate(new Date());
		staff.setUserName(staffRegistrationBean.getUserName());
		staff.setGender(gender);
		Organization inputOrganization = new Organization(staffRegistrationBean.getOrganization());
		Organization organization = new Organization();
		organization = new ObjectComparator().isOrganizationAlreadyDefined(inputOrganization);
		if (null != organization) {
			// do Nothing..
		} else {
			organization = new OrganizationDaoImpl().create(inputOrganization);
		}
		staff.setOrganization(organization);
		staff.setMobileNo(staffRegistrationBean.getPhoneNo());
		new StaffDaoImpl().create(staff);
		return true;
	}

	@Override
	public void updateUnsuccessfulAttempts(Staff staff) {
		staff.setUnsuccessfullLoginAttempts(staff.getUnsuccessfullLoginAttempts() + 1);
		new StaffDaoImpl().update(staff);
	}
}
