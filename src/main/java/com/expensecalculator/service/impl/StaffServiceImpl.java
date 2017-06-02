package com.expensecalculator.service.impl;

import com.expensecalculator.dao.impl.StaffDaoImpl;
import com.expensecalculator.domain.Staff;
import com.expensecalculator.service.StaffService;
import com.expensecalculator.ui.beans.LoginBean;

public class StaffServiceImpl implements StaffService {
	@Override
	public Staff authenticateStaff(LoginBean loginBean) {
		Staff staff = new StaffDaoImpl().findUnique(loginBean.getEmailId());
		if (staff != null)
			return staff;
		return null;
	}
}
