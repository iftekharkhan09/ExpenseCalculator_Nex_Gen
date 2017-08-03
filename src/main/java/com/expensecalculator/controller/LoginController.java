package com.expensecalculator.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.expensecalculator.domain.Staff;
import com.expensecalculator.service.StaffService;
import com.expensecalculator.ui.beans.LoginBean;

@Configuration
@EnableAspectJAutoProxy
@Controller
public class LoginController {
	final static Logger logger = Logger.getLogger(LoginController.class);
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

	@RequestMapping(value = "/showProfile", method = RequestMethod.GET)
	public String redirectToprofile(@ModelAttribute("loginBean") LoginBean loginBean, Model model,
			@Valid LoginBean loginBeans, Errors errors) {
		if (errors.hasErrors()) {
			return "login";
		}
		Staff staff = staffService.authenticateStaff(loginBean);
		if (null != staff) {
			model.addAttribute("staffData", staff);
			return "profilePage";
		}
		return "profileNotFound";
	}

	@RequestMapping(value = "/loginPage?logout", method = RequestMethod.GET)
	public String showLogoutPage() {
		return "logout";
	}

	@RequestMapping(value = "/loginPage?error", method = RequestMethod.GET)
	public String showErrorPage() {
		return "logout";
	}

	@PostConstruct
	public void init() {
		logger.debug("LoginController Bean has been Initialized.");
	}

	@PreDestroy
	public void destroy() {
		logger.debug("LoginController Bean has been Destroyed.");
	}
}