package com.ktds.jgbaek;

import java.util.Scanner;

public class Main {

	private int beverage[] = new int[3];
	private int totalPrice;

	public void start() {

		VendingMachine machine = new VendingMachine(15, 15, 15);
		Customer customer = new Customer(3000);
		Scanner userInput = new Scanner(System.in);

		while (true) {			
			if( customer.getMoney() < 600 ){
				System.out.println("돈이 없어 종료합니다.");
				break;
			}
			System.out.println("<Beverage Vending Machine>");
			System.out.print("coke, sprite, fanta 몇개씩 원하시나요? : ");
			for (int i = 0; i < beverage.length; i++) {
				beverage[i] = userInput.nextInt();
			}
			totalPrice = machine.getTotalPrice(beverage);

			while (true) {
				System.out.println("총 " + totalPrice + "원이 필요합니다.");
				System.out.print("돈을 넣어 주세요 : ");
				customer.pay(userInput.nextInt(), machine);
				System.out.println("현재 넣은 돈 : " + machine.getMoney() + "\n");

				if (totalPrice > machine.getMoney()) {
					System.out.println("돈이 부족합니다.");
					continue;
				} else {
					machine.giveBeverage(beverage, customer);
					machine.giveRemain(totalPrice, customer);
				}

				System.out.println("자판기에 남은 coke, sprite, fanta :" + machine.getBeverage()[0] + " "
						+ machine.getBeverage()[1] + " " + machine.getBeverage()[2]);
				System.out.println("나에게 남은 돈 : " + customer.getMoney() + "\n");
				break;
			}
		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}
}
