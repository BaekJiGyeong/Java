package com.ktds.jgbaek;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class RentalSystem {

	UserInput input = new UserInput();
	
	Date date = new Date();

	private int choice;
	private String wantBicycle;
	private String name;
	private long time;
	

	public void go(BicycleRentalShopBiz biz) {

		biz.bicycleInfoInRentalShop();

		while (true) {
			System.out.print("대여 하고 싶은 자전거 번호를 입력하세요 : ");
			choice = input.inputInt();
			wantBicycle = biz.selectBicycle(choice);
			
			if (wantBicycle.equals("error")) {
				continue;
			} 
			else {
				break;
			}
		}
		
		System.out.println("선택한 자전거 : "+wantBicycle);
		System.out.println("사용자 이름을 입력해주세요");
		name = input.inputString();
		Calendar now = Calendar.getInstance();
		time = now.getTimeInMillis()/1000;
		
		
		biz.addRentalInfo(name,choice,time);
		biz.rentalBicycle(choice);
		
		System.out.println(name+"님 " +date.toLocaleString()+" " + wantBicycle + "을 빌리셨습니다.");
		
		
	}
	

}
