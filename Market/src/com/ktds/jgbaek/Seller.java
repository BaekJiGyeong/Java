package com.ktds.jgbaek;

public class Seller {
	
	//인스턴스 필드 : 인스턴스만 접근할 수 있는 필드
	private int money;
	private int appleCount;
	private int applePrice;
	
	//static 붙으면 클래스 필드
	
	//생성자
	public Seller(){ // 이런식으로 기본형도 만들어 놓아야됨
		
	}
	public Seller ( int appleCount, int applePrice){
		this.setAppleCount(appleCount);
		this.setApplePrice(applePrice);
	}	
	public Seller( int money, int appleCount, int applePrice ) {
		this.setMoney(money);
		this.setAppleCount(appleCount);
		this.setApplePrice(applePrice);
	}
	
	/* 
	 * 메소드의 파라미터 개수가 다른 경우
	 * 메소드의 파라미터 종류가 다른 경우
	 * 를 메소드 오버로딩 이라 부른다.
	 */
	
	// 속성
	public int getMoney() {
		return money;
	}	
	public int getMoney ( int money){ //메소드 오버로딩, 이름이 똑같더라도 파라미터의 종류나 개수가 다르면 서로 다른것으로 인식
		return 0 ;
	}
	public int getMoney( long money, String money2) {
		return 0;
	}
	
	
	public void setMoney(int money) {
		this.money = money;
	}
	public int getAppleCount() {
		return appleCount;
	}
	public void setAppleCount(int appleCount) {
		this.appleCount = appleCount;
	}
	public int getApplePrice() {
		return applePrice;
	}
	public void setApplePrice(int applePrice) {
		this.applePrice = applePrice;
	}
	
	// 기능
	public void getMoneyFromCustomer( int money, Customer customer ) {
		this.money += customer.pay(money);		
	}
	
	public void giveApple( int appleCount, Customer customer ) {
		this.appleCount -= appleCount;
		customer.getApple(appleCount);
	}
	
	public void giveRemain( int money, int appleCount, Customer customer ) {
		int remain = money - ( appleCount * this.applePrice );
		this.money -= remain;
		customer.takeMoney(remain);
	}
	
	public void printMyInfo() {
		System.out.println("판매자가 가진 사과의 수 : " + this.appleCount);
		System.out.println("판매자가 가진 금액 : " + this.money);
	}
	
}
