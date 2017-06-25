package com.expensecalculator.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.expensecalculator.logging.MonitoringLogProcessor;

@Configuration
@Aspect
public class LoginLoggingDelegator {
	@Autowired
	MonitoringLogProcessor monitoringLogProcessor;

	private Logger logger = Logger.getLogger(getClass());

	@Pointcut("execution(* com.expensecalculator.controller.LoginController.*(..))")
	private void showLoginPage() {
	}

/*	@Pointcut("execution(* com.expensecalculator.controller.LoginController.redirectToprofile(LoginBean,Model,LoginBean,Errors))")
	private void redirectToprofile() {
	}*/

	@AfterReturning("showLoginPage()")
	public void showLoginPageRetured() {
		monitoringLogProcessor.setLog4jProperties();
		logger.info("Login page was displayed!!");
	}
	
	@AfterReturning("showLoginPage()")
	public void userSuccessfullyLoggedIn() {
		monitoringLogProcessor.setLog4jProperties();
		logger.info("");
	}


}