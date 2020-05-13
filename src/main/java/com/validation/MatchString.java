package com.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourceCodeConstraintVaidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MatchString {
	
	//define type with which it match
	public String type() default "contains";
	
	//define default cource code
	public String [] value() ;
	
	//define default error message	
	public String message() default "Given value is not valid";
	
	//define dafault groups
	public Class<?> [] groups() default{};
	
	//define default payloads
	public Class<? extends Payload>[] payload() default 	{};

}
