package com.expensecalculator.service;

import org.springframework.stereotype.Service;

import com.expensecalculator.domain.Staff;
import com.expensecalculator.ui.beans.LoginBean;
import com.expensecalculator.ui.beans.StaffRegistrationBean;

@Service
public interface StaffService {
	Staff authenticateStaff(LoginBean loginBean);
	boolean createStaff(StaffRegistrationBean staffRegistrationBean);
	void updateUnsuccessfulAttemptsAndBlockedStatus(Staff staff);
}
