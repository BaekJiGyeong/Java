package com.ktds.jgbaek;

import java.util.Scanner;

public class BicycleRentalShop {
	
	public void start() {
		
		BicycleRentalShopBiz biz = new BicycleRentalShopBiz();
		biz.startProgram();
		
	}
	
	public static void main(String[] args) {
		
		BicycleRentalShop shop = new BicycleRentalShop();
		shop.start();
		
	}

}
