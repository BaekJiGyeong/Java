package com.ktds.gmkim;

public class Loan {
	
	private LoanBiz biz;
	
	public void start() {
		
		biz = new LoanBiz();
		biz.startProgram();
	}

	public static void main(String[] args) {
		
		Loan test = new Loan();
		test.start();
		
	}
}
