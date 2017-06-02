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

@Controller
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginPage(Model model) {
		model.addAttribute("login", new LoginBean());
		return "login";
	}

	@RequestMapping(value = "/showProfile", method = RequestMethod.POST)
	public String authenticateUser(@ModelAttribute("login") LoginBean loginBean) {
		StaffServiceImpl staffServiceImpl = new StaffServiceImpl();
		Staff staff = staffServiceImpl.authenticateStaff(loginBean);
		if (null != staff)
			return "redirect:/showProfile";
		return "notFound";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/register")
	public String registerPage(ModelMap modelMap) {
		return "register";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registeruser")
	public String registerUser(ModelMap modelMap) {
		return "register";
	}
}