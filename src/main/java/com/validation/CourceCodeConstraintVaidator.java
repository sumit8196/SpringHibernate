package com.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import com.commons.Constants;

public class CourceCodeConstraintVaidator implements ConstraintValidator<MatchString, String> {

	private String[] matchingString;
	private String matchingType;
	//@Override
	public void initialize(MatchString theCourceCode) {
		this.matchingString=theCourceCode.value();
		this.matchingType=theCourceCode.type();
		
	}

	//@Override
	public boolean isValid(String theCode, ConstraintValidatorContext context) {
		if(theCode==null) {
			return true;
		}
		//String [] values=matchingString.split(",");
		boolean result=false;
		int countForAll=0;
		for(String value:matchingString) {
			if(matchingType.equalsIgnoreCase(Constants.STARTS_WITH_IGNORE_CASE_ANY)) {
				result=theCode.startsWith(value);
				break;
			}else if(matchingType.equalsIgnoreCase(Constants.ENDS_WITH_IGNORE_CASE_ANY)) {
				result=theCode.endsWith(value);
				break;
			}if(matchingType.equals(Constants.STARTS_WITH_ANY)) {
				result=theCode.startsWith(value);
				break;
			}else if(matchingType.equals(Constants.ENDS_WITH_ANY)) {
				result=theCode.endsWith(value);
				break;
			}else if(matchingType.equals(Constants.CONTAINS_ANY)){
				result=theCode.contains(value);
				break;
			}else if(matchingType.equals(Constants.CONTAINS_ANY_IGNORE_CASE)){
				result=theCode.toLowerCase().contains(value.toLowerCase());
				break;
			}else if(matchingType.equals(Constants.CONTAINS_ALL)) {
				if(theCode.contains(value)) {
					countForAll++;
				}
			}else if(matchingType.equals(Constants.CONTAINS_ALL_IGNORE_CASE)) {
				if(theCode.toLowerCase().contains(value.toLowerCase())) {
					countForAll++;
				}
			}
		}
		if(matchingType.equals(Constants.CONTAINS_ALL) || matchingType.equals(Constants.CONTAINS_ALL_IGNORE_CASE)) {
			if(countForAll==matchingString.length) {
				return true;
			}else {
				return false;
			}
		}
		return result;
	}

}
