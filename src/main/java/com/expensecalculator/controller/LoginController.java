package com.expensecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.expensecalculator.domain.Staff;
import com.expensecalculator.service.impl.StaffServiceImpl;
import com.expensecalculator.ui.beans.LoginBean;
import com.expensecalculator.ui.beans.StaffRegistrationBean;

@Controller
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginPage(Model model) {
		model.addAttribute("loginBean", new LoginBean());
		return "login";
	}

	@RequestMapping(value = "/showProfile", method = RequestMethod.POST)
	public String redirectToprofile(@ModelAttribute("loginBean") LoginBean loginBean,Model model) {
		StaffServiceImpl staffServiceImpl = new StaffServiceImpl();
		Staff staff = staffServiceImpl.authenticateStaff(loginBean);
		if (null != staff) {
			model.addAttribute("staffData",staff);
			return "profilePage";
		}
		return "profileNotFound";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/register")
	public String registerPage(Model model) {
		model.addAttribute("staffRegistrationBean",new StaffRegistrationBean());
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registerStaff")
	public String registerUser(@ModelAttribute("staffRegistrationBean") StaffRegistrationBean staffRegistrationBean,Model model) {
		StaffServiceImpl staffServiceImpl=new StaffServiceImpl();
		
		return "register";
	}
}