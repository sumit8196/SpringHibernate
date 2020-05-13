package com.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateUtils {
	//public  Logger  log = Logger.getLogger(this.getClass());
    private static final Logger log = Logger.getLogger(DateUtils.class);

    public static Date formatDate(Date date,String pattern) {
    	SimpleDateFormat dateFormat=new SimpleDateFormat(pattern);
    	String formattedDate= dateFormat.format(date);
    	try {
    		date=dateFormat.parse(formattedDate);
		} catch (ParseException e) {
			log.error("Error has occured at method : formatDate",e);
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		//formatDate(date, formatType)
    	return date;
    	
    }
}
