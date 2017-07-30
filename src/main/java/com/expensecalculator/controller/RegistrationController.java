package com.expensecalculator.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.expensecalculator.dao.impl.GenderDaoImpl;
import com.expensecalculator.service.StaffService;
import com.expensecalculator.ui.beans.StaffRegistrationBean;

@Controller
public class RegistrationController {
	final static Logger logger = Logger.getLogger(RegistrationController.class);
	private StaffService staffService;

	@Autowired
	public RegistrationController(StaffService staffService) {
		this.staffService = staffService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/register")
	public String registerStaffPage(Model model) {
		model.addAttribute("staffRegistrationBean", new StaffRegistrationBean());
		model.addAttribute("genderList", new GenderDaoImpl().findAll());
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registerStaff")
	public String registerStaff(@ModelAttribute("staffRegistrationBean") StaffRegistrationBean staffRegistrationBean,
			@Valid StaffRegistrationBean staffRegistrationBeans, Errors errors, Model model) {
		if (errors.hasErrors())
			return "register";
		staffService.createStaff(staffRegistrationBean);
		return "RegistrationDone";
	}

	@PostConstruct
	public void init(){
		logger.debug("LoginController Bean has been Initialized.");
	}
	
	@PreDestroy
	public void destroy(){
		logger.debug("LoginController Bean has been Destroyed.");
	}
}