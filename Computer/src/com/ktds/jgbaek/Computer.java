package com.ktds.jgbaek;

public class Computer {

	public void printAddition(int numberOne, int numberTwo) {

		int additionResult = numberOne + numberTwo;
		System.out.println(additionResult);
	}

	public void printSubtraction(int numberOne, int numberTwo) {

		int subtractionResult = numberOne - numberTwo;
		System.out.println(subtractionResult);
	}

	public void printMultiplication(int numberOne, int numberTwo) {

		int multiplicationResult = numberOne * numberTwo;
		System.out.println(multiplicationResult);
	}

	public void printDivision(int numberOne, int numberTwo) {

		double divisionResult = numberOne / numberTwo;
		System.out.println(divisionResult);
	}

	public int computeAddition(int numberOne, int numberTwo) { 
		int computeResult = numberOne + numberTwo;
		return computeResult;
	}
	public int computeSubtraction(int numberOne, int numberTwo) {
		int computeResult = numberOne - numberTwo;
		return computeResult;
	}
	public int computeMultiplication(int numberOne, int numberTwo) {
		int computeResult = numberOne * numberTwo;
		return computeResult;
	}
	public double computeDivision(int numberOne, int numberTwo) {
		return numberOne / (double) numberTwo;
	}

	public double calculator(int numberOne, int numberTwo, String operator) {
		double result = 0.0;
		if (operator.equals("+")) {
			result = computeAddition(numberOne,numberTwo);
		} 
		else if (operator.equals("-")) {
			result = computeSubtraction(numberOne,numberTwo);
		} 
		else if (operator.equals("*")) {
			result = computeMultiplication(numberOne,numberTwo);
		} 
		else {
			result = computeDivision(numberOne,numberTwo);
		}
		return result;

	}

}
