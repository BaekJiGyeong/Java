package com.ktds.jgbaek;

import java.util.Scanner;

public class ArtithmaticExceptionTest {
	public void start() {
		Scanner input = new Scanner(System.in);
		int numberOne = 0;
		int numberTwo = 0;
		double result = 0.0;

		System.out.println("첫 번째 숫자를 입력하세요.");
		numberOne = input.nextInt();
		System.out.println("두 번째 숫자를 입력하세요.");
		numberTwo = input.nextInt();

		try {
			result = numberOne / (double) numberTwo;
		} 
		catch (ArithmeticException ae) {
			System.out.println(ae.getMessage());
		}
		System.out.println("결과는 " + result + "입니다.");
	}

	public static void main(String[] args) {
		ArtithmaticExceptionTest test = new ArtithmaticExceptionTest();
		test.start();
	}

}
