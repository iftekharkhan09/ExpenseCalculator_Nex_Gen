package com.expensecalculator.controller;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.expensecalculator.dao.CategoryDao;
import com.expensecalculator.domain.Category;
import com.expensecalculator.service.ExpenseService;
import com.expensecalculator.ui.beans.ExpenseCreationBean;

@Controller
public class ExpenseController {
	final static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private ExpenseService expenseService;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping(value = "/addDetails", method = RequestMethod.GET)
	public String getExpenseEntryPage(Model model) {
		model.addAttribute("expenseCreationBean", new ExpenseCreationBean());
		System.out.println("I was here!!");
		List<Category> list = categoryDao.findAll();
		Iterator<Category> it = list.iterator();
		List<String> descriptions = new LinkedList<String>();
		while (it.hasNext()) {
			descriptions.add(it.next().getDescription());
		}
		model.addAttribute("categoryList", descriptions);
		return "addDetails";
	}
	
	@RequestMapping(value = "savedata", method = RequestMethod.POST)
	public String addExpense(@ModelAttribute("expenseCreationBean") ExpenseCreationBean expenseCreationBean, Model model) {
		expenseService.createExpense(expenseCreationBean);
		return "expenseAdded";
	}
	
	@PostConstruct
	public void init(){
		logger.debug("ExpenseController Bean has been Initialised.");
	}
	
	@PreDestroy
	public void destroy(){
		logger.debug("ExpenseController Bean has been Destroyed.");
	}
}
