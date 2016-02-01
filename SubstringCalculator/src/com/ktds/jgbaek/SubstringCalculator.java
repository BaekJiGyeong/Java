package com.ktds.jgbaek;

import java.util.Scanner;

public class SubstringCalculator {

	public void start() {

		while (true) {
			Scanner userInput = new Scanner(System.in);
			System.out.println("< 계산식을 입력하세요 >");
			String formula = userInput.nextLine();
			formula = formula.trim();
			formula = formula.replace(" ","");
			String operation="";
						
			for ( int i =0; i<formula.length(); i++) {
				if (formula.substring(i,i+1).equals("+")){
					operation = "+";
				}
				else if (formula.substring(i,i+1).equals("-")){
					operation = "-";
				}
				else if (formula.substring(i,i+1).equals("*")){
					operation = "*";
				}
				else if (formula.substring(i,i+1).equals("/")){
					operation = "/";
				}
			}
			
			int numberOne = Integer.parseInt(formula.substring(0,formula.indexOf(operation)));
			int numberTwo = Integer.parseInt(formula.substring(formula.indexOf(operation)+1,formula.length()));
			
			double result = calculator(numberOne, operation, numberTwo);
			System.out.println(numberOne + operation + numberTwo+" RESULT : " + result+"\n");
		}
	}

	public double calculator(int numberOne, String operation, int numberTwo) {
		double result = 0;
		if (operation.equals("+")) {
			result = numberOne + numberTwo;
		} else if (operation.equals("-")) {
			result = numberOne - numberTwo;
		} else if (operation.equals("*")) {
			result = numberOne * numberTwo;
		} else if (operation.equals("/")) {
			result = numberOne / (double) numberTwo;
		} else {
			result = 0;
		}
		return result;
	}

	public static void main(String[] args) {
		SubstringCalculator calculator = new SubstringCalculator();
		calculator.start();
	}
}
