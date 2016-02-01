package com.ktds.jgbaek;

import java.util.Calendar;
import java.util.Date;

public class DateTime {
	
	public void start() {
		
		// 현재시간 가져오기
		printCurrentMilliSecond();
		
		// 현재 날짜와 시간을 출력하기
		printCurrentDateTime();
		
		// 현재 날짜와 시간을 출력한다.
		printCurrentDateTimeByCalendar();
		
		printDateTimeByCalendar();
		
		printDateMinusDate();
		
		printTwoDayAfter();
		
	}


	private void printCurrentMilliSecond() {
		// TODO Auto-generated method stub
		long currentSeond = System.currentTimeMillis(); // 시작시간과 끝나는 시간이 얼마나 차이가 있는냐
		System.out.println(currentSeond);
	}

	private void printCurrentDateTime() {
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println(date.toGMTString()); // 표준시 독일기준
		System.out.println(date.toLocaleString());
	}
	
	private void printCurrentDateTimeByCalendar() {
		// TODO Auto-generated method stub
		
		Calendar now = Calendar.getInstance();
		System.out.println( now.toString() );
		
		System.out.println( now.get( Calendar.YEAR));
		System.out.println( now.get( Calendar.MONTH)+1);
		System.out.println( now.get( Calendar.DAY_OF_MONTH));
		System.out.println( now.get( Calendar.AM_PM));
		System.out.println( now.get( Calendar.HOUR));
		System.out.println( now.get( Calendar.HOUR_OF_DAY));
		System.out.println( now.get( Calendar.MINUTE));
		System.out.println( now.get( Calendar.SECOND));
		System.out.println( now.get( Calendar.MILLISECOND));
		System.out.println( now.get(Calendar.DAY_OF_WEEK)); // 1:일요일 2:월요일
		System.out.println( now.getActualMaximum( Calendar.DAY_OF_MONTH));
	
	}

	private void printDateTimeByCalendar() {
		// TODO Auto-generated method stub
		
		Calendar cal = Calendar.getInstance();
		cal.set(2016, (2-1), 14, 10, 59, 45);
		                   
		System.out.println();
		System.out.println( cal.get( Calendar.YEAR));
		System.out.println( cal.get( Calendar.MONTH)+1);
		System.out.println( cal.get( Calendar.DAY_OF_MONTH));
		System.out.println( cal.get( Calendar.AM_PM));
		System.out.println( cal.get( Calendar.HOUR));
		System.out.println( cal.get( Calendar.HOUR_OF_DAY));
		System.out.println( cal.get( Calendar.MINUTE));
		System.out.println( cal.get( Calendar.SECOND));
		System.out.println( cal.get( Calendar.MILLISECOND));
		System.out.println( cal.get(Calendar.DAY_OF_WEEK)); // 1:일요일 2:월요일
		System.out.println( cal.getActualMaximum( Calendar.DAY_OF_MONTH));
		                   
	}
	
	private void printDateMinusDate() {
		// TODO Auto-generated method stub
		Calendar now = Calendar.getInstance();
		
		Calendar cal = Calendar.getInstance();
		cal.set(2016, (2-1), 14, 10, 59, 45);
	
		long dateTime1 = now.getTimeInMillis();
		long dateTime2 = cal.getTimeInMillis();
		
		System.out.println(dateTime1);
		System.out.println(dateTime2);
		
		long result = (dateTime2 - dateTime1)/1000; // 진짜 초
		System.out.println(result);
		
		int date = (int) Math.round ((double) result / 60 / 60/ 24 );
		System.out.println("일자 : " + ( date));
		
		int hour = (int) Math.round ((double) result / 60 / 60 );
		System.out.println( "시간 : " + ( hour));
		
		int minute = (int) Math.round ((double) result / 60  );
		System.out.println("분 : " + minute);
		
		System.out.println(minute % 60);
	
	}

	private void printTwoDayAfter() {
		// TODO Auto-generated method stub
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 3);
		cal.add(Calendar.MONTH, -1); // 한달전
		
		System.out.println();
		System.out.println( cal.get( Calendar.YEAR));
		System.out.println( cal.get( Calendar.MONTH)+1);
		System.out.println( cal.get( Calendar.DAY_OF_MONTH));
		System.out.println( cal.get( Calendar.AM_PM));
		System.out.println( cal.get( Calendar.HOUR));
		System.out.println( cal.get( Calendar.HOUR_OF_DAY));
		System.out.println( cal.get( Calendar.MINUTE));
		System.out.println( cal.get( Calendar.SECOND));
		System.out.println( cal.get( Calendar.MILLISECOND));
		System.out.println( cal.get(Calendar.DAY_OF_WEEK)); // 1:일요일 2:월요일
		System.out.println( cal.getActualMaximum( Calendar.DAY_OF_MONTH));
		
	}
	
	public static void main(String[] args) {
	
		DateTime dateTime = new DateTime();
		dateTime.start();
		
		
		
	}
}
