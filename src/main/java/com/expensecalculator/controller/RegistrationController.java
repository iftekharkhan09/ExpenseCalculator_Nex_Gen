package com.expensecalculator.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.expensecalculator.service.impl.StaffServiceImpl;
import com.expensecalculator.ui.beans.StaffRegistrationBean;

@Controller
public class RegistrationController {
	@RequestMapping(method = RequestMethod.GET, value = "/register")
	public String registerStaffPage(Model model) {
		model.addAttribute("staffRegistrationBean", new StaffRegistrationBean());
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registerStaff")
	public String registerStaff(@ModelAttribute("staffRegistrationBean") StaffRegistrationBean staffRegistrationBean,
			@Valid StaffRegistrationBean staffRegistrationBeans, Errors errors, Model model) {
		if (errors.hasErrors())
			return "register";
		StaffServiceImpl staffServiceImpl = new StaffServiceImpl();
		staffServiceImpl.createStaff(staffRegistrationBean);
		return "RegistrationDone";
	}
}
