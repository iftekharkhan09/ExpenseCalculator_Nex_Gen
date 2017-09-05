package com.expensecalculator.service.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.expensecalculator.dao.GenderDao;
import com.expensecalculator.dao.StaffDao;
import com.expensecalculator.dao.TitleDao;
import com.expensecalculator.dao.impl.NameDaoImpl;
import com.expensecalculator.dao.impl.OrganizationDaoImpl;
import com.expensecalculator.dao.impl.StaffDaoImpl;
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

@Service
public class StaffServiceImpl implements StaffService {
	private final int NOOFALLOWEDUNSUCCESSFULATTEMPTS = 3;

	@Autowired
	private StaffDao staffDao;

	@Autowired
	private GenderDao genderDao;

	@Autowired
	private Staff staff;

	@Autowired
	private Name name;

	@Autowired
	private Organization organization;

	@Autowired
	private ObjectComparator objectComparator;

	@Autowired
	private TitleDao titleDao;

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

	public boolean createStaff(StaffRegistrationBean staffRegistrationBean) {
		Title title=titleDao.findByTitle(staffRegistrationBean.getTitle());
		staff.setTitle(title);
		Name inputName = new Name(staffRegistrationBean.getFirstName(), staffRegistrationBean.getLastName());
		boolean isNameAlreadydefined;
		isNameAlreadydefined = objectComparator.isNameAlreadyDefined(inputName);
		if (isNameAlreadydefined) {
			// do Nothing..
		} else
			new NameDaoImpl().create(inputName);
		Gender gender=genderDao.findByGender(staffRegistrationBean.getGender());
		staff.setGender(gender);
		name = new NameDaoImpl().findByName(inputName.getFirstName(), inputName.getLastName());
		staff.setGender(gender);
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
		Organization inputOrganization = new Organization(staffRegistrationBean.getOrganization());
		boolean isOrganizationAlreadyDefined;
		isOrganizationAlreadyDefined = objectComparator.isOrganizationAlreadyDefined(inputOrganization);
		if (isOrganizationAlreadyDefined) {
			// do Nothing..
		} else {
			new OrganizationDaoImpl().create(inputOrganization);
		}
		organization = new OrganizationDaoImpl().findByName(inputOrganization.getOrganizationName());
		staff.setOrganization(organization);
		staff.setMobileNo(staffRegistrationBean.getPhoneNo());
		new StaffDaoImpl().create(staff);
		return true;
	}

	public void updateUnsuccessfulAttemptsAndBlockedStatus(Staff staff) {
		int unsuccessfullLoginAttempts = staff.getUnsuccessfullLoginAttempts();
		staff.setUnsuccessfullLoginAttempts(unsuccessfullLoginAttempts + 1);
		if (unsuccessfullLoginAttempts + 1 > NOOFALLOWEDUNSUCCESSFULATTEMPTS)
			staff.setIsBlocked('Y');
		new StaffDaoImpl().update(staff);
	}
}