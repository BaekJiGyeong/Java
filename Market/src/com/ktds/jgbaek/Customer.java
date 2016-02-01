package com.ktds.jgbaek;

public class Customer {
	
	// 구매자가 가지는 속성
	// 인스턴스 필드
	
	/**
	 *  구매자가 가지고 있는 금액
	 */
	private int money;
	
	/**
	 *  구매자가 가지고 있는 사과의 수
	 */
	private int appleCount;
	
	public void setMoney( int money ) {
		this.money = money;
	}
	
	public void setAppleCount( int appleCount ) {
		this.appleCount = appleCount;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public int getAppleCount() {
		return this.appleCount;
	}
	
	// 한 개의 메소드는 하나의 기능만 수행해야 한다.
	// 돈을 준다.
	public int pay( int money) {
		this.money -= money;
		return money;
	}
	
	// 사과를 받는다.
	public void getApple( int appleCount) {
		this.appleCount += appleCount;
	}
	
	// 거스름돈을 받는다.
	public void takeMoney( int money ) {
		this.money += money;
	}
	
	public void printMyInfo() {
		System.out.println("구매자가 가진 사과의 수 : " + this.appleCount);
		System.out.println("구매자가 가진 돈 : " + this.money);
	}
	
}
