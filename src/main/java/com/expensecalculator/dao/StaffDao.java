package com.expensecalculator.dao;

import com.expensecalculator.domain.Staff;

public interface StaffDao {
	 Staff findUnique(String userName);
	 Staff authenticateStaff(String userName,String password);
}
