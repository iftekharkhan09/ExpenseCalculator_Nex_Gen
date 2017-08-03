package com.expensecalculator.service.test;

import com.expensecalculator.dao.impl.GenderDaoImpl;
import com.expensecalculator.domain.Gender;

import net.sf.ehcache.CacheManager;

public class SecondLevelCacheTest {
	public static void main(String[] args) {
		Gender gender=new Gender();
		//gender.setId(3);
		gender.setGender("DFG");
		GenderDaoImpl g=new GenderDaoImpl();
		//g.create(gender);
		System.out.println(g.findUnique(1).getGender());
		System.out.println(g.findUnique(1).getGender());
		System.out.println(g.findUnique(2).getGender());
		double size = CacheManager.ALL_CACHE_MANAGERS.get(0)
				  .getCache("com.expensecalculator.domain.Gender").getSize();
		System.out.println(size);
	}
}