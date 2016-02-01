package com.ktds.jgbaek;

import java.util.Scanner;

public class Main {

	public static final int EGG_PRICE = 1000;

	public void start() {

		Customer customer = new Customer();
		VendingMachine machine = new VendingMachine();
		Scanner userInput = new Scanner(System.in);
		String state = "";

		System.out.println("<계란 자판기>");

		while (true) {

			System.out.println("현재 금액 : " + machine.getMoney());																	
			System.out.println("현재 계란 : " + machine.getEgg());
			System.out.println("사용자 금액 : " + customer.getMoney());
			System.out.println("사용자 계란 : " + customer.getEgg());
			System.out.println("돈을 넣어 주세요 : ");
			customer.pay(userInput.nextInt(), machine); // 소비자가 돈을 넣어줌

			if (machine.getEgg() == 0 || customer.getMoney() < EGG_PRICE) {
				System.out.println("판매 종료");
				break;
			} 
			else if (machine.getMoney() < EGG_PRICE) {
				continue;
			}
			machine.giveEgg(customer);
			machine.giveRemain(customer);
		}
	}

	public static void main(String[] args) {

		Main main = new Main();
		main.start();
	}
}
