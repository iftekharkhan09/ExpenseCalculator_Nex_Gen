package com.expensecalculator.controller;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.expensecalculator.dao.GenderDao;
import com.expensecalculator.dao.TitleDao;
import com.expensecalculator.domain.Gender;
import com.expensecalculator.domain.Title;
import com.expensecalculator.ui.beans.StaffProfileBean;

@Controller
public class ProfileController {

	@Autowired
	private GenderDao genderDao;

	@Autowired
	private TitleDao titleDao;

	@RequestMapping(value = "/StaffProfile", method = RequestMethod.GET)
	public String showStaffFullRegistrationPage(@ModelAttribute("staffProfileBean") StaffProfileBean staffProfileBean,
			Model model) {
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
		model.addAttribute("gendersMap", genderMap);
		return "StaffProfile";
	}
	
	@RequestMapping(value="/updateStaffProfile",method= RequestMethod.POST)
	public String updateStaffProfile(@ModelAttribute("staffProfile") StaffProfileBean staffProfileBean) {
		return "null";
	}
}
