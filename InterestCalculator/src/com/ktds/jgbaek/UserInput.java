package com.ktds.jgbaek;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
	
	private Scanner scanner;
	
	public int inputInt() {		
		scanner = new Scanner( System.in );
		while ( true ) {			
			try {
				return scanner.nextInt();
			}
			catch (InputMismatchException ime) {
				scanner = new Scanner(System.in);
				System.out.println("정수만 입력해주세요.");
			}
		}
	}
	
	public String inputString () {		
		scanner = new Scanner( System.in );		
		return scanner.nextLine();
	}


}
