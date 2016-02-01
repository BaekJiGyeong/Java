package com.ktds.jgbaek;

public class ThrowsTest {

	public void start() {
		MakeExceptions makeExceptions = new MakeExceptions();
		int number = 0;
		
		number = makeExceptions.parseInt("1234");

		try {
			number = makeExceptions.parseInt2("DEF");
		} catch (NumberFormatException nfe) {
			System.out.println("변환 실패!");
			number=0;
		}
		
		System.out.println(number);
		number = makeExceptions.parseInt3("DEF");
		
//		try {
//			number = makeExceptions.parseInt3("DEF");
//		} catch (invalidNumberException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
		
//		try {
//			number = makeExceptions.parseInt3("DEF");
//		} catch (NumberFormatException nfe) {
//			System.out.println("변환 실패!!!!!!");
//			number=0;
//		}
		
		System.out.println(number);
	}

	public static void main(String[] args) {
		ThrowsTest test = new ThrowsTest();
		test.start();
	}

}
