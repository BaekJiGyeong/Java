package com.ktds.jgbaek;

public class Customer {
	
	private int age;
	private int money;
	private int cigarrete;
		
	public void setAge ( int age ) {
		this.age = age;
	}
	public int getAge () {
		return this.age;
	}
	public void setMoney (int money ) {
		this.money = money;
	}
	public int getMoney () {
		return this.money;
	}
	
	public boolean pay ( int money, ConvenienceStore store ) {
		this.money -= money;
		return store.takeMoney(money);	
	}
	
	public void takeCigarrete ( int cigar ) {
		this.cigarrete += cigar;
		System.out.println("담배 "+cigar + "개를 받았습니다.");
	}
	
	public void takeRemain ( int money ) {
		this.money += money;
	}
	
	public void takeInfo () {
		System.out.println("당신이 갖고 있는 돈은 " + this.money+"원 이고 갖고 있는 담배는 "+this.cigarrete+"개 입니다." );
	}
}
