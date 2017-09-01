package com.expensecalculator.controller;

import java.util.Iterator;
import java.util.LinkedHashMap;
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
import com.expensecalculator.dao.UnitDao;
import com.expensecalculator.dao.UserDao;
import com.expensecalculator.domain.Category;
import com.expensecalculator.domain.Unit;
import com.expensecalculator.domain.User;
import com.expensecalculator.service.ExpenseService;
import com.expensecalculator.ui.beans.ExpenseCreationBean;

@Controller
public class ExpenseController {
	final static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private ExpenseService expenseService;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UnitDao unitDao;

	@RequestMapping(value = "/addDetails", method = RequestMethod.GET)
	public String getExpenseEntryPage(Model model) {
		List<Category> categories = categoryDao.findAll();
		Iterator<Category> it = categories.iterator();
		Map<String, String> categoryMap = new LinkedHashMap<String, String>();
		while (it.hasNext()) {
			Category cat = it.next();
			categoryMap.put(cat.getDescription(), cat.getDescription());
		}
		List<User> users = userDao.findAllUsers();
		Iterator<User> usersIterator = users.iterator();
		Map<String, String> usersMap = new LinkedHashMap<String, String>();
		while (usersIterator.hasNext()) {
			User user = usersIterator.next();
			usersMap.put(user.getUsername(), user.getUsername());
		}
		Map<String, String> unitsMap=new LinkedHashMap<String, String>();
		List<Unit> units=unitDao.findAll();
		Iterator<Unit> unitsIterator=units.iterator();
		while(unitsIterator.hasNext()) {
			Unit unit=unitsIterator.next();
			unitsMap.put(unit.getDescription(),unit.getDescription());
		}
		model.addAttribute("users",users);
		model.addAttribute("categoriesMap", categoryMap);
		model.addAttribute("usersMap", usersMap);
		model.addAttribute("unitsMap", unitsMap);
		model.addAttribute("expenseCreationBean", new ExpenseCreationBean());
		return "addDetails";
	}

	@RequestMapping(value = "/savedata", method = RequestMethod.POST)
	public String addExpense(@ModelAttribute("expenseCreationBean") ExpenseCreationBean expenseCreationBean,
			Model model) {
		expenseService.createExpense(expenseCreationBean);
		return "expenseAdded";
	}

	@PostConstruct
	public void init() {
		logger.debug("ExpenseController Bean has been Initialised.");
	}

	@PreDestroy
	public void destroy() {
		logger.debug("ExpenseController Bean has been Destroyed.");
	}
}
