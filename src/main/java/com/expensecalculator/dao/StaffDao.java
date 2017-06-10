package com.expensecalculator.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.expensecalculator.domain.Staff;

@Repository
public interface StaffDao {
	 Staff findUnique(String userName);
	 Staff findByUsernameAndPassword(String userName,String password);
	 boolean addStaff(Staff staff);
}
