package com.ktds.jgbaek;

import java.util.ArrayList;
import java.util.List;

public class BicycleRentalShopBiz {

	public static final int POPULAR_BICYCLE_PRICE = 1000;
	public static final int INTERMEDIATE_BICYCLE_PRICE = 2000;
	public static final int HIGHEND_BICYCLE_PRICE = 5000;

	private int popularBicycle;
	private int intermediateBicycle;
	private int highendBicycle;

	private List<BicycleRentalShopVO> bicycleRentalBook;
	private RentalSystem rental;
	private UserInput input;
	private RentalSystem rentalSystem;
	private ReturnSystem returnSystem;

	BicycleRentalShopBiz() {
		this.bicycleRentalBook = new ArrayList<BicycleRentalShopVO>();
		this.rental = new RentalSystem();
		this.input = new UserInput();
		this.rentalSystem = new RentalSystem();
		this.returnSystem = new ReturnSystem();
		this.popularBicycle = 10;
		this.intermediateBicycle = 3;
		this.highendBicycle = 2;

	}

	// BicycleRentalShopVO getter
	public List<BicycleRentalShopVO> getBicycleRentalBook() {
		return bicycleRentalBook;
	}

	// BicycleRentalShopVO setter
	public void setBicycleRentalBook(List<BicycleRentalShopVO> bicycleRentalBook) {
		this.bicycleRentalBook = bicycleRentalBook;
	}
	
	public int getPopularBicycle() {
		return popularBicycle;
	}
	public void setPopularBicycle(int popularBicycle) {
		this.popularBicycle = popularBicycle;
	}
	public int getIntermediateBicycle() {
		return intermediateBicycle;
	}
	public void setIntermediateBicycle(int intermediateBicycle) {
		this.intermediateBicycle = intermediateBicycle;
	}
	public int getHighendBicycle() {
		return highendBicycle;
	}
	public void setHighendBicycle(int highendBicycle) {
		this.highendBicycle = highendBicycle;
	}
	
	public int getBicyclePrice(int number) {
		if (number == 1) {
			return 1000;
		} else if (number == 2) {
			return 2000;
		} else {
			return 5000;
		}
	}

	public void startProgram() {

		while (true) {
			System.out.println("<<BicycleRentalShop>>");
			System.out.println("1:대여 2:반납 Exit:종료");
			String userWant = input.inputString();

			// 대여
			if (userWant.equals("1")) {
				rentalSystem.go(this);
			} else if (userWant.equals("2")) {
				returnSystem.go(this);
			} else if (userWant.equalsIgnoreCase("Exit")) {
				System.out.println("렌탈샵을 나옵니다.");
				System.exit(0);
			} else {
				System.out.println("정확하게 입력해주세요.");
			}
		}
	}

	public String selectBicycle(int number) {
		String bicycle = "";
		if (number == 1) {
			bicycle = "popular bicycle";
			
		} else if (number == 2) {
			bicycle = "intermediate bicycle";
			
		} else if (number == 3) {
			bicycle = "highend bicycle";
			
		} else {
			bicycle = "error";
		}
		return bicycle;
	}

	public void rentalBicycle(int number) {
		if (number == 1) {
			popularBicycle --;
		} else if (number == 2) {
			intermediateBicycle--;
		} else if (number == 3) {
			highendBicycle--;
		}
	}

	public void returnBicycle(int number) {
		if (number == 1) {
			popularBicycle = popularBicycle +1;
		} else if (number == 2) {
			intermediateBicycle = intermediateBicycle +1;
		} else if (number == 3) {
			highendBicycle = highendBicycle +1;
		}
	}
	
	public int calculatorPrice (long nowTime, long userTime, int bicycleNumber ) {
		int time=0;
		int price=0;
		System.out.println(bicycleNumber);
		time = (int)(nowTime-userTime) / 60 ;
		price = (time-(time%10))/10 * this.getBicyclePrice(bicycleNumber);
		return price;
	}

	// 정보 입력
	public void addRentalInfo(String name, int choice, long time) {
		BicycleRentalShopVO info = new BicycleRentalShopVO();
		info.setName(name);
		info.setBicycle(choice);
		info.setDate(time);
		this.bicycleRentalBook.add(info);
	}

	// 정보 제거
	public void removeRentalInfo(BicycleRentalShopVO info) {
		this.bicycleRentalBook.remove(info);
	}

	// 이름과 같은 정보 반환
	public BicycleRentalShopVO returnBicycleRentalInfo(String name) {

		for (BicycleRentalShopVO vo : this.getBicycleRentalBook()) {
			if (vo.getName().equals(name)) {
				return vo;
			}
		}
		return new BicycleRentalShopVO();
	}

	public boolean isAddressEmpty(String name) {

		for (BicycleRentalShopVO vo : this.getBicycleRentalBook()) {

			if (vo.getName().equals(name)) {
				return false;
			}
		}
		return true;
	}

	public void bicycleInfoInRentalShop() {
		System.out.println("현재 이용 가능한 자전거는");
		System.out.println("1번 보급 자전거 (10분당 1000원): " + this.getPopularBicycle());
		System.out.println("2번 중급 자전거 (10분당 2000원): " + this.getIntermediateBicycle());
		System.out.println("3번 고급 자전거 (10분당 5000원): " + this.getHighendBicycle() + "대 입니다.");
	}
}
