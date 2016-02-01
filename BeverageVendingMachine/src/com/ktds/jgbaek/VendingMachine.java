package com.ktds.jgbaek;

public class VendingMachine {

	private int money;
	private int beverage[] = new int[] { 0, 0, 0 }; // coke, sprite, fanta
	public static final int BEVERAGE_PRICE[] = new int[] { 900, 800, 600 };
	


	public VendingMachine(int coke, int sprite, int fanta) {
		this.beverage[0] = coke;
		this.beverage[1] = sprite;
		this.beverage[2] = fanta;
	}

	public int[] getBeverage() {
		return beverage;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getMoney() {
		return this.money;
	}

	// coke
	public void setCoke(int coke) {
		this.beverage[0] = coke;
	}

	public int getCoke() {
		return this.beverage[0];
	}

	// sprite
	public void setSprite(int sprite) {
		this.beverage[1] = sprite;
	}

	public int getSprite() {
		return this.beverage[1];
	}

	// fanta
	public void setFanta(int fanta) {
		this.beverage[2] = fanta;
	}

	public int getFanta() {
		return this.beverage[2];
	}
	
	public int getTotalPrice(int beverage[]){
		int totalPrice = 0;
		for (int i = 0; i < beverage.length; i++) {
			totalPrice += beverage[i] * this.BEVERAGE_PRICE[i];
		}
		return totalPrice;
	}

	// 돈을 받는다.
	public void takeMoney(int money) {
		this.money += money;
	}

	// 음료수를 준다.
	public void giveBeverage(int beverage[], Customer customer) {
		for (int i = 0; i < beverage.length; i++) {
			this.beverage[i] -= beverage[i];
		}
		customer.takeBeverage(beverage);
	}

	// 거스름 돈을 준다.
	public void giveRemain(int totalPrice, Customer customer) {
		this.money -= totalPrice;
		customer.takeRemain(this.money);
		System.out.println("거스름돈 : " + this.money);
		this.money = 0;
	}

}
