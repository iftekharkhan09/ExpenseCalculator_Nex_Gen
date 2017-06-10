package com.expensecalculator.dao;

import org.springframework.stereotype.Service;
import com.expensecalculator.domain.Staff;

@Service
public interface StaffDao {
	 Staff findUnique(String userName);
	 Staff findByUsernameAndPassword(String userName,String password);
	 boolean addStaff(Staff staff);
}
