package com.ktds.jgbaek;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	private String state = "";
	private boolean payState;

	public void start() {

		Customer customer = new Customer();
		ConvenienceStore store = new ConvenienceStore();
		Scanner userInput = new Scanner(System.in);

		System.out.println("<담배사는 프로그램>");

		while (true) {
			System.out.println("Customer Age : ");
			try {
				Scanner userInput1 = new Scanner(System.in);
				customer.setAge(userInput1.nextInt());
				break;
			} catch (InputMismatchException ime) {
				System.out.println("잘못 입력하셨습니다. 정수만 입력해 주세요.");
				System.out.println(ime.getClass().getName() + "예외가 " + ime.getMessage() + "때문에 발생하였습니다.");
				Scanner userInput1 = new Scanner (System.in);
			}
		}

		System.out.println("Customer Money : ");
		customer.setMoney(userInput.nextInt());

		while (true) {
			if (customer.getAge() < 20 || customer.getMoney() < 5000 || store.getCigarrete() <= 0) {
				store.close();
				break;
			} else {
				System.out.print("담배를 사겠습니까? (yes/no)");
				state = userInput.next();

				if (state.equalsIgnoreCase("no")) {
					store.close();
					break;
				} else {
					System.out.print("구매하실 담배 개수를 입력해주세요 " + ": ");
					store.takeOrder(userInput.nextInt());

					while (!payState) { // not true
						System.out.print("지불하실 금액을 입력해주세요 : ");
						payState = customer.pay(userInput.nextInt(), store);
					}
				}

				store.giveCigarrete(customer);
				store.giveRemain(customer);

				customer.takeInfo();
				store.takeInfo();
			}
		}
	}

	public static void main(String[] args) {

		Main main = new Main();
		main.start();

	}
}
