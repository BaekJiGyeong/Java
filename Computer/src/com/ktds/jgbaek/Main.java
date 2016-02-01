package com.ktds.jgbaek;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Computer computer = new Computer();

		// computer.printAddition( 30, 60 );
		// computer.printSubtraction(100, 50);
		// computer.printMultiplication(10, 5);
		// computer.printDivision(10, 2);

		int additionResult = computer.computeAddition(100, 200);
		// 메소드를 호출한 결과는 받아야한다.
		System.out.println(additionResult);

		int subtractionResult = computer.computeSubtraction(50, 10);
		System.out.println(subtractionResult);

		int multiplicationResult = computer.computeMultiplication(50, 250);
		System.out.println(multiplicationResult);

		double divisionResult = computer.computeDivision(50, 10);
		System.out.println(divisionResult);

		// 메소드 1개 파라미터 3개 ( 정수 2개, 문자열 1개)
		// int 와 String에 연산자
		// 입력받은 연산자로 숫자를 써라

		Scanner userInput = new Scanner(System.in);
		System.out.print("First Number : ");
		int numberOne = userInput.nextInt();
		System.out.print("Second Number : ");
		int numberTwo = userInput.nextInt();
		System.out.print("Operator : ");
		String operator = userInput.next();

		double result = computer.calculator(numberOne, numberTwo, operator);
		
		System.out.println("메인에서 출력 : "+result);
	}

}
