package com.expensecalculator.service;

import com.expensecalculator.domain.Staff;
import com.expensecalculator.ui.beans.LoginBean;

public interface StaffService {
	public Staff authenticateStaff(LoginBean loginBean);

}
