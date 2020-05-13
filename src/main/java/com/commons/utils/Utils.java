package com.commons.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

public class Utils {
	public static String getCurrentTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return dateFormat.format(calendar.getTime());

	}
	public static String getURLPath(HttpServletRequest request){
		String currentPath = request.getRequestURI();
		String queryString = request.getQueryString();
		queryString = queryString == null ? " " : "?" + queryString;
		return currentPath + queryString;
	}
}
