package com.ktds.jgbaek;

public class WhatOperator {
	
	public void getText(String operator){
		if (operator.equals("+")){
			System.out.println("더하기");
		}
		else if (operator.equals("-")){
			System.out.println("빼기");
		}
		else if (operator.equals("*")){
			System.out.println("곱하기");
		}
		else if (operator.equals("/")){
			System.out.println("나누기");
		}
	}

}
