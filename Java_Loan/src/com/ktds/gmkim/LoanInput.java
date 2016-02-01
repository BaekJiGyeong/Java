package com.ktds.gmkim;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoanInput {

	private Scanner scanner;

	/**
	 * 기본 생성자
	 */
	public LoanInput () {
		scanner = new Scanner( System.in );
	}
	
	/**
	 * 정수 입력
	 * @return
	 */
	public int inputInt() {
		
		scanner = new Scanner( System.in );

		while ( true ) {
			
			try {
				return scanner.nextInt();
			}
			catch (InputMismatchException ime) {
				scanner = new Scanner(System.in);
				System.out.println("정수로 다시 입력 하세요.");
			}
		}
	}
	
	/**
	 * long 입력
	 * @return
	 */
	public long inputLong() {
		
		scanner = new Scanner( System.in );

		while ( true ) {
			
			try {
				return scanner.nextLong();
			}
			catch (InputMismatchException ime) {
				scanner = new Scanner(System.in);
				System.out.println("Long 로 다시 입력 하세요.");
			}
		}
	}
	
	/**
	 * 실수 입력
	 * @return
	 */
	public double inputDouble() {
		
		scanner = new Scanner( System.in );
		
		return scanner.nextDouble();
	}
	
	/**
	 * 문자열 입력
	 * @return
	 */
	public String inputString () {
		
		scanner = new Scanner( System.in );
		
		return scanner.nextLine();
	}
}	
