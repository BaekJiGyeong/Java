package com.ktds.jgbaek;

import java.util.Scanner;

public class Lesson0120 {
	public static void main(String[] args) {

//		Scanner userInput = new Scanner(System.in);
//		// 과제 1 : 자기소개 출력하는 메소드
//		Hello hello = new Hello();
//		System.out.println(hello.getHello());
//
//		// 과제 2 : 연산자 입력시 텍스트 출력하는 메소드
//		WhatOperator operator1 = new WhatOperator();
//		System.out.print("+,-,*,/ 중에 하나를 입력하시오 : ");
//		operator1.getText(userInput.next());

		// 과제 3 : 사칙연산 계산기 메소드
		
		Scanner userInput = new Scanner(System.in);
		String state = "";
		int numberOne = 0;
		int numberTwo = 0;
		String operator = "";
		double result = 0;
		Calculator calculator = new Calculator();		

		while (true) {
			System.out.println("<calculator>");
			System.out.println("계산을 원하시면 go");
			System.out.println("종료를 원하시면 exit을 입력해주세요.");
			state = userInput.next();

			if (state.equalsIgnoreCase("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} 
			else if (state.equalsIgnoreCase("go")) {
				System.out.print("First number : ");
				numberOne = userInput.nextInt();
				System.out.print("Second number : ");
				numberTwo = userInput.nextInt();
				System.out.print("Select operator + - * / : ");
				operator = userInput.next();
				
				result = calculator.getResult(numberOne, numberTwo, operator);
				System.out.println("Result : "+numberOne+operator+numberTwo+"="+result+"\n");

			}

		}

	}

}
