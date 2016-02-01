package com.ktds.jgbaek;

public class Calculator {
	
	public double getResult(int numberOne, int numberTwo, String operator){
		
		double result = 0;
		
		if (operator.equals("+")){
			result = numberOne + numberTwo;
		}
		else if (operator.equals("-")){
			result = numberOne - numberTwo;
		}
		else if (operator.equals("*")){
			result = numberOne * numberTwo;
		}
		else if (operator.equals("/")){
			result = numberOne / numberTwo;
		}
		return result;
	}
	
	public Calculator() {
		
	}

}
