package com.ktds.jgbaek;

import java.util.ArrayList;
import java.util.List;

public class ArrayIndexOutOfBoundExceptionTest {
	public void start() {
		caseOne();
		caseTwo();

	}

	public void caseOne() {
		// 배열을 사용함
		int numbers[] = new int[5];
		
		for ( int i = 0; i< numbers.length; i++ ) {
			numbers[i] = i;
		}
		try {
			numbers[5] = 10;
		}
		catch( ArrayIndexOutOfBoundsException aioobe) {
			System.out.println(aioobe.getMessage() + "인덱스는 존재하지 않습니다.");
		}
		
		
		/*
		 * 결과
		 * ====
		 * 0 : 첫 번째 인덱스
		 * 1 : 두 번째 인덱스
		 * 2 : ..
		 * 3 : ..
		 * 4 : 다섯 번째 인덱스
		 */
		for ( int number : numbers ) {
			System.out.println(number);
		}
	}

	public void caseTwo() {
		
		List<Integer> numbers = new ArrayList<Integer>();
		for ( int i = 0 ; i<5; i++ ) {
			numbers.add(i);
		}
		for ( int i = 0 ; i<numbers.size(); i++ ) {
			System.out.println(numbers.get(i));
		}

		/*
		 * 결과
		 * ====
		 * 0 : 첫 번째 인덱스
		 * 1 : 두 번째 인덱스
		 * 2 : ..
		 * 3 : ..
		 * 4 : 다섯 번째 인덱스
		 */
		numbers.add(0);

	}

	public static void main(String[] args) {
		ArrayIndexOutOfBoundExceptionTest test = new ArrayIndexOutOfBoundExceptionTest();
		test.start();
	}
}
