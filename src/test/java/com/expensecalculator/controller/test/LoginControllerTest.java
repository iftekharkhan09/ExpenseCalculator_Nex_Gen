/*package com.expensecalculator.controller.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import com.expensecalculator.controller.LoginController;
import com.expensecalculator.domain.Staff;
import com.expensecalculator.service.StaffService;
import com.expensecalculator.ui.beans.LoginBean;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
	private MockMvc mockMvc;
	private static LoginController loginController;

	@Mock
	private StaffService staffService;

	@Before
	public void setUp() {
		loginController = new LoginController(staffService);
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).setViewResolvers(viewResolver).build();
	}
@Test
	public void testShowLoginPage() throws Exception {
		mockMvc.perform(get("/")).andExpect(view().name("Login")).andExpect(model().attributeExists("loginBean"));
	}

	@Test
	public void testShowProfile() throws Exception {
		LoginBean loginBean = new LoginBean();
		loginBean.setUserName("iftekhar09");
		loginBean.setPassword("Sunny@981");
		Staff staff = staffService.authenticateStaff(loginBean);
		if (null != staff)
			mockMvc.perform(get("/showProfile")).andExpect(view().name("showProfile"));
		else
			mockMvc.perform(get("/showProfile")).andExpect(view().name("profileNotFound"));
	}
}*/