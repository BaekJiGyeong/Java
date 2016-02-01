package com.ktds.jgbaek;

public class InterestCalculator {
	
	public void start() {
		
		BankBiz biz = new BankBiz();
		biz.startProgram();
		
	}
	
	public static void main(String[] args) {
		
		InterestCalculator calculator = new InterestCalculator();
		calculator.start();
		
	}

}
