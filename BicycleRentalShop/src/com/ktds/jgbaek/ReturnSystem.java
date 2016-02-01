package com.ktds.jgbaek;

import java.util.Calendar;

public class ReturnSystem {
	UserInput input = new UserInput();
	
	private int choice;
	private String name;
	private long nowTime ;
	private long userTime;
	private int price;
	private int userMoney;
	BicycleRentalShopVO info;

	public void go(BicycleRentalShopBiz biz) {
		while (true) {
			
			System.out.println("사용자 이름을 입력하세요.");
			name = input.inputString();

			if (!biz.isAddressEmpty(name)) {
				info = biz.returnBicycleRentalInfo(name);
				break;
			} 
			else {
				System.out.println("없습니다.");
			}
		}
		
		choice = info.getBicycle();
		userTime = info.getDate();
		choice = info.getBicycle();
		name = info.getName();
		
		Calendar now = Calendar.getInstance();
		nowTime = now.getTimeInMillis()/1000;
		
		price = biz.calculatorPrice(nowTime, userTime, choice);
		System.out.println(name + "님의 이용 금액은 " + price + "원 입니다.");
		System.out.print("현재 구매자가 가진 금액 : ");
		userMoney = input.inputInt();
		System.out.println("대여료 지불하고 남은 금액은 "+(userMoney-price) + "원 입니다.");
		biz.returnBicycle(choice);
		biz.removeRentalInfo(info);
	}

}
