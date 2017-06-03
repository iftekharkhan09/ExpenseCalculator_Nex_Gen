package com.expensecalculator.service;

import com.expensecalculator.domain.Staff;
import com.expensecalculator.ui.beans.LoginBean;
import com.expensecalculator.ui.beans.StaffRegistrationBean;

public interface StaffService {
	public Staff authenticateStaff(LoginBean loginBean);
	//public boolean createStaff(StaffRegistrationBean staffRegistrationBean);
}
