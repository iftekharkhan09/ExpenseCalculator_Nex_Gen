package com.expensecalculator.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingDelegator {
	  private Logger logger = Logger.getLogger(getClass());

	@Before("execution=(* com.expensecalculator.*(..))")
	public void log(JoinPoint joinpoint) {
		logger.info(joinpoint.getSignature().getName() + " called...");
	}

}
