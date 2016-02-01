package com.ktds.jgbaek;

public class Customer {
	private int money;
	private int beverage[] = new int[] {0,0,0} ; // coke, sprite, fanta
	
	public Customer (int money ){
		this.money = money;
	}
	
	public void setMoney ( int money ){
		this.money = money;
	}
	public int getMoney () {
		return this.money;
	}
	
	public void setBeverage ( int beverage[]) {
		this.beverage = beverage;
	}
	public int[] getBeverage (){
		return this.beverage;
	}
	
	
//	// coke
//	public void setCoke ( int coke ) {
//		this.beverage[0] = coke;
//	}
//	public int getCoke () {
//		return this.beverage[0];
//	}
//	// sprite
//	public void setSprite ( int sprite ) {
//		this.beverage[1] = sprite;
//	}
//	public int getSprite () {
//		return this.beverage[1];
//	}
//	// fanta
//	public void setFanta ( int fanta ) {
//		this.beverage[2] = fanta;
//	}
//	public int getFanta () {
//		return this.beverage[2];
//	}
	
	// 돈을 넣는다.
	public void pay ( int money, VendingMachine machine ){
		this.money -=money;
		machine.takeMoney(money);
	}
	// 음료를 받는다.
	public void takeBeverage ( int beverage[] ){
		for ( int i = 0; i < beverage.length; i++){
			this.beverage[i] += beverage[i];
		}
		System.out.println("음료를 받았습니다.\n");
	}
	
	// 거스름 돈을 받는다.
	public void takeRemain ( int remain ) {
		this.money += remain;
	}
}
