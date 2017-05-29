package com.expensecalculator.controller.test;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.expensecalculator.controller.LoginController;

public class LoginControllerTest {
	@Test
	public void homePageTest() throws Exception {
		LoginController controller = new LoginController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/")).andExpect(view().name("login"));
	}
}
