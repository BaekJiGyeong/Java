package com.ktds.jgbaek;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMissmatchExceptionTest {

	public void start() {
		System.out.println("정수를 입력하세요!");

		Scanner input = new Scanner(System.in);
		int number1 = 0;
		int number2 = 0;
		int number3 = 0;
		int currentStatus = 1;

		// 사용자가 정수를 입력할 때까지 반복한다.
		while (true) {

			// 예외가 발생할지 아닐지 모르지만, 우선 실행해본다.
			try {
				
				switch ( currentStatus ) {
				case 1 :
					System.out.println("첫 번째 수를 입력하세요.");
					// 예외가 발생할 가능성이 있는 코드들...
					number1 = input.nextInt();
					currentStatus = 2;
				case 2 :
					System.out.println("두 번째 수를 입력하세요.");
					number2 = input.nextInt();
					currentStatus = 3;
				case 3 :
					System.out.println("세 번째 수를 입력하세요.");
					number3 = input.nextInt();
					currentStatus = 1;
				}
				break;
			}
			
			// try 내부의 코드가 InputMismatchException 을 던진다면,
			// 예외를 받아온다.
			// catch가 실행되는 동안은 Program이 종료되지 않는다.
			catch (InputMismatchException ime) {
				//  Scanner의 에러를 해결하기 위한 코드
				input = new Scanner ( System.in );
				System.out.println("잘못 입력했습니다! 정수만 입력할 수 있어요.");
				
				// 쓰면 안되는 코드
				// 예외의 구체적인 정보를 알고싶을때 쓴다.
				// 구체적인 정보를 알고 난뒤에는 반드시 지워야한다.
				// ime.printStackTrace();
				
				// 애용해야하는 코드
				// 어떤 예외가 어떻게 발생했는지 간략히 알려준다,
				System.out.println(ime.getClass().getName() + "예외가 " + ime.getMessage() + "때문에 발생했습니다.");
			}
		}

		System.out.println("당신이 입력한 정수는 " + number1 + "입니다. ");
		System.out.println("당신이 입력한 정수는 " + number2 + "입니다. ");
		System.out.println("당신이 입력한 정수는 " + number3 + "입니다. ");

	}

	public static void main(String[] args) {
		InputMissmatchExceptionTest test = new InputMissmatchExceptionTest();
		test.start();
	}

}
