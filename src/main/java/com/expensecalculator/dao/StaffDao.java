package com.expensecalculator.dao;

import com.expensecalculator.domain.Staff;

public interface StaffDao {
	 Staff findByEmailAndPassword(String emailId,String password);
	 boolean addStaff(Staff staff);
	 Staff findByEmail(String emailId);
}
