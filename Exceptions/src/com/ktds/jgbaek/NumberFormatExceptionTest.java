package com.ktds.jgbaek;

import java.util.Scanner;

public class NumberFormatExceptionTest {
	public int parseInt (String str ) {
		try {
			return Integer.parseInt(str);
		}
		catch ( NumberFormatException nfe){
			return 0;
		}
	}
	
	public void start() {
		
		Scanner input = new Scanner ( System.in );
		String numberString = input.next();
		
		// 문자를 정수로 변환한다.
		// 문자를 long으로 변환한다.
		// 문자를 short으로 변환한다.
		// 문자를 int로 변환한다.
		try {
		int integerNumber = Integer.parseInt( numberString );
		System.out.println(integerNumber);
		}
		catch ( NumberFormatException nfe) {
			System.out.println("숫자 변환에 실패했습니다.");
			System.out.println(nfe.getMessage());
		}
		// 문자를 실수로 변환한다.
		// 문자를 double로 변환한다.
		// 문자를 float으로 변환한다.
		
		// 문자를 불린으로 변환한다.
		
	}
	
	public static void main(String[] args) {
		NumberFormatExceptionTest test = new NumberFormatExceptionTest();
		test.start();
	}

}
