package com.ktds.jgbaek;

public class ConvenienceStore {
	
	private int cigarrete = 5;
	private int money;
	public static final int CIGARRETE_PRICE = 5000;
	private int totalPrice;
	private int needCigarrete;

	public void setCigarrete ( int cigarrete ) {
		this.cigarrete = cigarrete;
	}
	public int getCigarrete () {
		return this.cigarrete;
	}
	public void setMoney (int money ) {
		this.money = money;
	}
	public int getMoney () {
		return this.money;
	}
	
	public void takeOrder ( int need ) {
		this.needCigarrete = need;
		
		if ( this.cigarrete < need ) {
			System.out.println("현재 남아있는 담배는 "+this.cigarrete+"개 입니다.");
		}
		else {
			totalPrice = need*this.CIGARRETE_PRICE;
			System.out.println(totalPrice+"원 입니다.");
		}
	}
	
	public boolean takeMoney ( int money ) {
		
		this.money += money;
		System.out.println("현재 내신 금액은 "+this.money+"원 입니다.");
		
		if ( totalPrice > this.money ) {
			int needMoney = totalPrice - this.money;
			System.out.println(totalPrice+"원 중에 "+needMoney+"원이 모자랍니다.");
			return false;
		}
		else return true;		
	}
	
	public void giveCigarrete ( Customer customer ) {
		this.cigarrete -= this.needCigarrete;
		System.out.println("담배 "+ this.needCigarrete + "개를 받으세요.");
		customer.takeCigarrete(this.needCigarrete);
	}
	
	public void giveRemain ( Customer customer ) {
		if (this.totalPrice < this.money){
			customer.takeRemain(this.money-this.totalPrice);
			System.out.println("거스름 돈 " + (this.money-this.totalPrice )+ "원 입니다.");
		}
	}
	
	public void takeInfo() {
		System.out.println("편의점에서 남은 담배는 " + this.cigarrete + "개 입니다.");
	}
	
	public void close() {
		System.out.println("판매를 종료합니다.");
	}

}
