package com.expensecalculator.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.expensecalculator.dao.GenderDao;
import com.expensecalculator.dao.GenericDao;
import com.expensecalculator.dao.NameDao;
import com.expensecalculator.dao.OrganizationDao;
import com.expensecalculator.dao.StaffDao;
import com.expensecalculator.dao.TitleDao;
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

@Component
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDao staffDao;

	@Autowired
	private GenderDao genderDao;

	@Autowired
	private Staff staff;

	@Autowired
	private Title title;

	@Autowired
	private Gender gender;
	
	@Autowired
	private NameDao nameDao;
	
	@Autowired
	private Organization organization;
	
	@Autowired
	private ObjectComparator objectComparator;
	
	@Autowired
	private TitleDao titleDao;
	/*@Autowired
	private OrganizationDao organizationDao;*/

	@Override
	public Staff authenticateStaff(LoginBean loginBean) {
		staff = staffDao.findUnique(loginBean.getUserName());
		if (null != staff) {
			if (staff.getIsBlocked() == 'N' && staff != null && staff.getUserName().equals(loginBean.getUserName())
					&& staff.getPassword().equals(loginBean.getPassword())) {
				staff.setLastLogin(new Date());
				new StaffDaoImpl().update(staff);
				return staff;
			} else if (staff.getIsBlocked() == 'N' && staff != null
					&& staff.getUserName().equals(loginBean.getUserName())) {
				updateUnsuccessfulAttemptsAndBlockedStatus(staff);
			}
		}
		return null;
	}

	@Override
	public boolean createStaff(StaffRegistrationBean staffRegistrationBean) {
		title = titleDao.findUnique(1);
		Name inputName = new Name(staffRegistrationBean.getFirstName(), staffRegistrationBean.getLastName(), title);
		Name name = new Name();
		name = objectComparator.isNameAlreadyDefined(inputName);
		if (null != name) {
			// do Nothing..
		} else {
			name = new NameDaoImpl().create(inputName);
		}
		gender = new GenderDaoImpl().findUnique(1);
		Gender gender1=gender;
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
		staff.setGender(gender1);
		Organization inputOrganization = new Organization(staffRegistrationBean.getOrganization());
		organization = objectComparator.isOrganizationAlreadyDefined(inputOrganization);
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
	public void updateUnsuccessfulAttemptsAndBlockedStatus(Staff staff) {
		int unsuccessfullLoginAttempts = staff.getUnsuccessfullLoginAttempts();
		staff.setUnsuccessfullLoginAttempts(unsuccessfullLoginAttempts + 1);
		if (unsuccessfullLoginAttempts + 1 > 3)
			staff.setIsBlocked('Y');
		new StaffDaoImpl().update(staff);
	}
}
