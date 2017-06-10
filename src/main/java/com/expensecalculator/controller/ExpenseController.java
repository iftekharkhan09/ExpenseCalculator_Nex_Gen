package com.expensecalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExpenseController {
	@RequestMapping("/addDetails")
	public String getExpenseEntryPage(Model model) {
		return "addDetails";
	}
}
