package com.online_cab_booking.ride.aop;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoginAspect {

private Logger LOGGER = Logger.getLogger(getClass().getName());
	
	@Pointcut("* execution(com.online_cab_booking.ride.controller.*.*(...))")
	private void forControllerPackage() {
		LOGGER.info("Controller Package is being executed");
	}
	@Pointcut("* execution(com.online_cab_booking.ride.service.*.*(....))")
	private void forServicePackage() {
		LOGGER.info("Service Package is being executed");
	}
	@Pointcut("* execution(com.online_cab_booking.ride.repository)")
	private void forRepositoryPackage() {
		LOGGER.info("Repository package is being executed");
	}
	@Pointcut("forControllerPackage() || forServicePackage() || forRepositoryPackage()")
	private void forAppFlow() {
		LOGGER.info("application data flow");
	}
	@Before("forAppFlow")
	public void before(JoinPoint joinPoint) {
		String theMethod = joinPoint.getSignature().toShortString();
		LOGGER.info("In @Before: calling method: "+theMethod);
		// display the arguments to the method
		//get the arguments to the method 
		Object[] args = joinPoint.getArgs();
		// loop through and display arguments
		for(Object tempArg : args) {
			LOGGER.info("argument"+tempArg);
		}
	}
		@AfterReturning(
				pointcut = "forAppFlow()",
				returning = "theResult"
				)
		
		public void afterReturning(JoinPoint joinPoint) {
	        // displaying method we are returning from
			String theMethod = joinPoint.getSignature().toShortString();
			LOGGER.info("In @AfterReturning: from method: "+theMethod);
			// display the data returned
			LOGGER.info("Result:"+theMethod);
			
		}
		
	
}
