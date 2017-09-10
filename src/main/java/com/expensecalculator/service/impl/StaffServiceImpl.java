package com.expensecalculator.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.expensecalculator.dao.GenderDao;
import com.expensecalculator.dao.NameDao;
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
	private NameDao nameDao;

	@Autowired
	private StaffDao staffDao;

	@Autowired
	private GenderDao genderDao;

	@Autowired
	private Staff staff;

	@Autowired
	private Name name;

	@Autowired
	private ObjectComparator objectComparator;

	@Autowired
	private TitleDao titleDao;

	public Staff authenticateStaff(LoginBean loginBean) {
		// staff = staffDao.findUnique(loginBean.getUserName());
		// if (null != staff) {
		// if (staff.getIsBlocked() == 'N' && staff != null &&
		// staff.getUserName().equals(loginBean.getUserName())
		// && staff.getPassword().equals(loginBean.getPassword())) {
		// staff.setLastLogin(new Date());
		// new StaffDaoImpl().update(staff);
		// return staff;
		// } else if (staff.getIsBlocked() == 'N' && staff != null
		// && staff.getUserName().equals(loginBean.getUserName())) {
		// updateUnsuccessfulAttemptsAndBlockedStatus(staff);
		// }
		// }
		// return null;
		return null;
	}

	public boolean createStaff(StaffRegistrationBean staffRegistrationBean) {
		String firstName=staffRegistrationBean.getFirstName();
		String lastName=staffRegistrationBean.getLastName();
		String email=staffRegistrationBean.getEmail();
		Staff staff = new StaffDaoImpl().findByEmail(email);
		if (null != staff) {
			return false;
		}
		Name name=nameDao.findByName(firstName,lastName);
		if(null!=name) {
			//do nothing..
		}
		else
			new NameDaoImpl().create(new Name(firstName,lastName));
		Name displayName=new NameDaoImpl().findByName(firstName,lastName);
		Staff createdStaff=new Staff();
		createdStaff.setName(displayName);
		createdStaff.setEmail(staffRegistrationBean.getEmail());
		createdStaff.setPassword(staffRegistrationBean.getPassword());
		new StaffDaoImpl().addStaff(createdStaff);
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