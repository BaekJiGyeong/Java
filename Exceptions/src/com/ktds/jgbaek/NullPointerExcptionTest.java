package com.ktds.jgbaek;

public class NullPointerExcptionTest {
	public void start() {

		String str = null; // 인스턴스화 되어있지 않은 포인트 = nullpoint

		for ( int i = 0; i < 3; i++ ) {
			
			if ( str!=null && str.equals("AAA") ) { // 인스턴스화 되어있지 않은 변수 
				System.out.println("AAA 입니다. ");
			}
			else {
				System.out.println("에러 입니다.");
			}
			
		}

	}

	public static void main(String[] args) {

		/*
		 * -Primitive Type의 기본 값- ============================ int default : 0
		 * short 0 long 0L // long number = 10L; byte 0 float 0.0F double 0.0D
		 * or 0.0 boolean false char ' '
		 * 
		 * Reference Type의 기본 값 String null Scanner null System null
		 * NullPointerException null
		 */

		NullPointerExcptionTest test = new NullPointerExcptionTest();
		test.start();
	}
}
