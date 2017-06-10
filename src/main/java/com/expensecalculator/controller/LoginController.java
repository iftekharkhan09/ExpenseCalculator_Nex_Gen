package com.expensecalculator.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
		model.addAttribute("loginBean", new LoginBean());
		return "login";
	}

	@RequestMapping(value = "/showProfile", method = RequestMethod.POST)
	public String redirectToprofile(@ModelAttribute("loginBean") LoginBean loginBean,Model model,@Valid LoginBean loginBeans, Errors errors) {
		if(errors.hasErrors()) {
			return "login";
		}
		StaffServiceImpl staffServiceImpl = new StaffServiceImpl();
		Staff staff = staffServiceImpl.authenticateStaff(loginBean);
		if (null != staff) {
			model.addAttribute("staffData",staff);
			return "profilePage";
		}
		else if() {
			
		}
		return "profileNotFound";
	}
}