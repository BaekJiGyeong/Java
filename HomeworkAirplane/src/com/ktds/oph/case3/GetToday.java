package com.ktds.oph.case3;

import java.util.Calendar;

public class GetToday {
	
	public static String getNowTime() {
		
//		Date date = new Date();
//		System.out.println(date.toString());
		
		Calendar now = Calendar.getInstance();
		int year    = now.get(Calendar.YEAR);                
		int month  = now.get(Calendar.MONTH) + 1;          
		int day    = now.get(Calendar.DAY_OF_MONTH);
		int hour    = now.get(Calendar.HOUR);                 
		int minute  = now.get(Calendar.MINUTE);             
		int second  = now.get(Calendar.SECOND);
		
		String date = year+"년"+month+"월"+day+"일"+hour+"시"+minute+"분"+second+"초";
//		System.out.println(year+"년"+month+"월"+day+"일"+hour+"시"+minute+"분"+second+"초");
		return date;
	}

}
