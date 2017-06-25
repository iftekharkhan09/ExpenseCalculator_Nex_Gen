/*package com.expensecalculator.service.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.expensecalculator.dao.GenericDao;
import com.expensecalculator.dao.impl.GenderDaoImpl;
import com.expensecalculator.dao.impl.GenericDaoImpl;
import com.expensecalculator.domain.Staff;
import com.expensecalculator.service.StaffService;
import com.expensecalculator.service.impl.StaffServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class StaffServiceTest {
	@Mock
	private GenericDao<Staff> genericDao;
	private StaffServiceImpl staffServiceImpl;
	@Before
	public void Setup() {
		genericDao=new GenericDaoImpl<>();
	}
	@Test
	public void authenticateStaffTest() {
		Staff staff=new Staff();
		staff.setUserName("iftekhar091");
		staff.setPassword("Sunny@981");
		staff.setIsBlocked('N');
	}
	

}
*/