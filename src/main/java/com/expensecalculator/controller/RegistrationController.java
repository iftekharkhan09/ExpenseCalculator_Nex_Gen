package com.expensecalculator.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
		return "StaffRegistration";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registerStaff")
	public ModelAndView registerStaff(
			@ModelAttribute("staffRegistrationBean") StaffRegistrationBean staffRegistrationBean) {
		boolean isNewStaff = staffService.createStaff(staffRegistrationBean);
		ModelAndView modelAndView = new ModelAndView();
		if (isNewStaff) {
			modelAndView.addObject("staffRegistrationBean", staffRegistrationBean);
			modelAndView.setViewName("StaffProfile");
		} else {
			modelAndView.setViewName("StaffAlreadyExists");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUser() {
		return "addUser";
	}

	@RequestMapping(value = "/addStaff", method = RequestMethod.GET)
	public String addStaff() {
		return "addStaff";
	}

	@PostConstruct
	public void init() {
		logger.debug("RegistrationController Bean has been Initialized.");
	}

	@PreDestroy
	public void destroy() {
		logger.debug("RegistrationController Bean has been Destroyed.");
	}
}