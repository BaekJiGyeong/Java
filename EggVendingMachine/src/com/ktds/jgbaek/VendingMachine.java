package com.ktds.jgbaek;

import java.util.Scanner;

public class VendingMachine {
	
	private int money=0;
	private int egg=30;
	
	public void setMoney( int money ) {
		this.money = money;
	}
	public int getMoney() {
		return this.money;
	}
	public void setEgg(int egg ) {
		this.egg = egg;
	}
	public int getEgg() {
		return this.egg;
	}
	
	// 돈을 받는다.
	public void takeMoney( int money ){
		this.money += money;
	}
	// 계란을 준다.
	public void giveEgg (Customer customer) {
		this.egg--;
		this.money -= Main.EGG_PRICE; 
		customer.takeEgg();
	}
	// 거스름 돈을 준다.
	public void giveRemain (Customer customer) {
		customer.takeRemain(this.money) ;
		this.money = 0;
	}
	
	

}
