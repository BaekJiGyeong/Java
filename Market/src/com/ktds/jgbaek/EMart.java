package com.ktds.jgbaek;

public class EMart {
	
	public void start(){
	
		Seller 과일장수1 = new Seller(50000,20,1500); // 밑에 3줄 역할을 해줌
		System.out.println(과일장수1); // 참조형 변수 출력하면 메모리 주소가 나옴
		
		Seller 과일장수2 = new Seller(5000,1,5000);
		Seller 과일장수3 = new Seller();
		과일장수3.setAppleCount(10);
		과일장수3.setApplePrice(500);
		
		Customer 백지경 = new Customer();
		백지경.setMoney(60000);
		백지경.setAppleCount(0);
		
		과일장수1.getMoneyFromCustomer(3000, 백지경);
		과일장수1.printMyInfo();
		백지경.printMyInfo();
		
		과일장수1.giveApple(1, 백지경);
		과일장수1.printMyInfo();
		백지경.printMyInfo();
		
		과일장수1.giveRemain(3000, 1, 백지경);
		과일장수1.printMyInfo();
		백지경.printMyInfo();
		
		과일장수2.getMoneyFromCustomer(5000, 백지경);
		과일장수2.printMyInfo();
		백지경.printMyInfo();
		
		과일장수2.giveApple(1, 백지경);
		과일장수2.printMyInfo();
		백지경.printMyInfo();
		
		과일장수2.giveRemain(5000, 1, 백지경);
		과일장수2.printMyInfo();
		백지경.printMyInfo();
		
		
//		과일장수1.setAppleCount(20);
//		과일장수1.setMoney(50000);
//		과일장수1.setApplePrice(1500);
		
	}
	
	public static void main(String[] args){
		
		EMart mart = new EMart();
		mart.start();
	}

}
