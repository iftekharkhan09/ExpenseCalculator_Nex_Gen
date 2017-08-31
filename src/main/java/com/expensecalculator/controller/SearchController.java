package com.expensecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchController {
	@RequestMapping(method=RequestMethod.GET,value="/searchExpense")
	public String showExpenseSearchScreen(Model model) {
		return "/searchExpense";
	}
}
