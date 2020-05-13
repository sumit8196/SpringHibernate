package com.org.commons.AOP;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class AOP extends AOPExpression{
 	   Logger log=Logger.getLogger(AOP.class);
	  @Before("basePackage()") 
	  public void entryLog(JoinPoint point) {
		  Object object[]= point.getArgs();
	   log.info("[AOP] Entry at: "+point.getSignature().toShortString()+" and argument: ["+object+"]");
	   }
	  @Around("customerService()")
	  public Object processingTime(ProceedingJoinPoint point) throws Throwable {
		  String method= point.getSignature().toLongString();
			long beginTime =System.currentTimeMillis();
			Object object=null;
			try {
				object = point.proceed();
			}catch(Exception  exception) {
				log.error("[AOP]: Exception has occured at: "+method);
				throw exception;
			}
			long endTime=System.currentTimeMillis();
			long duration=(endTime-beginTime)/1000;
			log.info("[AOP]: Time taken for " +method+ "(in sec): "+duration);
			return object;
	  }
	 @AfterReturning(pointcut="customerService()",returning="result")
	 public void afterReturning(JoinPoint point,Object result) {
		 String method= point.getSignature().toLongString();
		 log.info("[AOP]:Result for "+method+" is->> " +result);
	 }
}
