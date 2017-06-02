package com.expensecalculator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expensecalculator.domain.Staff;
import com.expensecalculator.service.StaffService;
import com.expensecalculator.service.impl.StaffServiceImpl;
import com.expensecalculator.ui.beans.LoginBean;

@Controller
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	private String homePage(ModelMap model) {
		return "login";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/register")
	public String registerPage(ModelMap modelMap) {
		return "register";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/registeruser")
	public String registerUser(ModelMap modelMap) {
		return "register";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLoginPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new LoginBean());
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") LoginBean login) {
		ModelAndView mav = null;
		StaffServiceImpl staffServiceImpl=new StaffServiceImpl();
		Staff staff = staffServiceImpl.validateStaff(login);
		if (null != staff) {
			mav = new ModelAndView("welcome");
			mav.addObject("firstname", staff.getId());
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}
}