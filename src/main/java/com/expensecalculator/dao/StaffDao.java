package com.expensecalculator.dao;

import com.expensecalculator.domain.Staff;

public interface StaffDao {
	 Staff findUnique(String userName);
	 Staff findByUsernameAndPassword(String userName,String password);
	 boolean addStaff(Staff staff);
}
