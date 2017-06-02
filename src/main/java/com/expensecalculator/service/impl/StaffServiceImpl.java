package com.expensecalculator.service.impl;

import com.expensecalculator.dao.impl.StaffDaoImpl;
import com.expensecalculator.domain.Staff;
import com.expensecalculator.service.StaffService;
import com.expensecalculator.ui.beans.LoginBean;

public class StaffServiceImpl implements StaffService {
	@Override
	public Staff authenticateStaff(LoginBean loginBean) {
		Staff staff = new StaffDaoImpl().findUnique("we");
		if (staff != null)
			return staff;
		return null;
	}
	public static void main(String[] args) {
		Staff staff=new StaffServiceImpl().authenticateStaff(null);
		System.out.println(staff);
		System.out.println(staff.getId());
	}
}
