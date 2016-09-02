package com.nshpage.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class UserServiceLogger {
	
	private Logger logger = LoggerFactory.getLogger(UserServiceLogger.class);
	
	
	@After("execution(* join(..))")
	public void joinServiceLogging() {
		logger.info("join request");
	}
	@After("execution(* login(..))")
	public void loginServiceLogging() {
		logger.info("login request");
	}
	
}
