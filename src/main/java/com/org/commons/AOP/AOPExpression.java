package com.org.commons.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;

//@Aspect
@Component
public class AOPExpression {

	@Pointcut("execution(* *.*(..))")
	public void allRequest() {
	};

	@Pointcut("execution(* com.org.*.*.*(..))")
	public void basePackage() {
	};

	@Pointcut("execution(* com.org.dao*.*(..))")
	public void daoPackage() {
	};

	@Pointcut("execution(* com.org.service.CustomerService.*(..))")
	public void customerService() {
	};

	@Pointcut("execution(void com.org.service.CustomerService.deleteNow(int))")
	public void deleteCustomer() {
	};

	// Expression end here

}
