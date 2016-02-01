package com.ktds.jgbaek;

public class Customer {
	
	private int money;
	private int egg;
	
	public Customer (){
		this.money = 5000;
	}
	
	
	
	public void setMoney ( int money ) {
		this.money = money;
	}
	public int getMoney () {
		return this.money;
	}
	public void setEgg ( int egg ) {
		this.egg = egg;
	}
	public int getEgg () {
		return this.egg;
	}
	
	
	
	// 돈을 지불한다.
	public void pay ( int money, VendingMachine machine ) {
		this.money -= money;
		machine.takeMoney(money); // 지불한 돈을 기계가 받는다.
	}
	
	// 계란을 받는다.
	public void takeEgg () {
		this.egg += 1;
		System.out.println("계란을 1개 받았습니다.");
	}
	
	// 거스름 돈을 받는다.
	public void takeRemain ( int remain ) {
		this.money += remain;
		System.out.println("거스름돈 " + remain +"원을 받았습니다.");
	}

}
