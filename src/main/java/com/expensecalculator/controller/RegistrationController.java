package com.expensecalculator.controller;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.expensecalculator.dao.GenderDao;
import com.expensecalculator.dao.TitleDao;
import com.expensecalculator.domain.Gender;
import com.expensecalculator.domain.Title;
import com.expensecalculator.service.StaffService;
import com.expensecalculator.ui.beans.StaffRegistrationBean;

@Controller
public class RegistrationController {
	final static Logger logger = Logger.getLogger(RegistrationController.class);
	private StaffService staffService;

	@Autowired
	private GenderDao genderDao;
	
	@Autowired
	private TitleDao titleDao;

	@Autowired
	public RegistrationController(StaffService staffService) {
		this.staffService = staffService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/register")
	public String registerStaffPage(Model model) {
		List<Gender> genders = genderDao.findAll();
		Iterator<Gender> genderIterators = genders.iterator();
		Map<String, String> genderMap = new LinkedHashMap<String, String>();
		while (genderIterators.hasNext()) {
			Gender gender = genderIterators.next();
			genderMap.put(gender.getGender(), gender.getGender());
		}
		Map<String, String> titleMap = new LinkedHashMap<String, String>();
		List<Title> titles = titleDao.findAll();
		Iterator<Title> titleIterator = titles.iterator();
		while (titleIterator.hasNext()) {
			Title title = titleIterator.next();
			titleMap.put(title.getTitle(), title.getTitle());
		}
		model.addAttribute("titleMap", titleMap);
		model.addAttribute("gendersMap",genderMap);
		model.addAttribute("staffRegistrationBean", new StaffRegistrationBean());
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/registerStaff")
	public String registerStaff(@ModelAttribute("staffRegistrationBean") StaffRegistrationBean staffRegistrationBean,
			@Valid StaffRegistrationBean staffRegistrationBeans, Errors errors, Model model) {
		// if (errors.hasErrors())
		// return "register";
		staffService.createStaff(staffRegistrationBean);
		return "RegistrationDone";
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