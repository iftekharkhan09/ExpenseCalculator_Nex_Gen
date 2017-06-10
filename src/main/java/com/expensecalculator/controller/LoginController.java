package com.expensecalculator.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.expensecalculator.domain.Staff;
import com.expensecalculator.service.StaffService;
import com.expensecalculator.ui.beans.LoginBean;

@Controller
public class LoginController {
	private StaffService staffService;
	@Autowired
	public LoginController(StaffService staffService) {
		this.staffService = staffService;
	}
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginPage(Model model) {
		model.addAttribute("loginBean", new LoginBean());
		return "login";
	}

	@RequestMapping(value = "/showProfile", method = RequestMethod.POST)
	public String redirectToprofile(@ModelAttribute("loginBean") LoginBean loginBean,Model model,@Valid LoginBean loginBeans, Errors errors) {
		if(errors.hasErrors()) {
			return "login";
		}
		Staff staff = staffService.authenticateStaff(loginBean);
		if (null != staff) {
			model.addAttribute("staffData",staff);
			return "profilePage";
		}
		return "profileNotFound";
	}
}