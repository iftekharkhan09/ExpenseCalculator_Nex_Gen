package com.expensecalculator.service;

import com.expensecalculator.domain.Staff;
import com.expensecalculator.ui.beans.LoginBean;
import com.expensecalculator.ui.beans.StaffRegistrationBean;

public interface StaffService {
	Staff authenticateStaff(LoginBean loginBean);
	boolean createStaff(StaffRegistrationBean staffRegistrationBean);
	void updateUnsuccessfulAttemptsAndBlockedStatus(Staff staff);
}
