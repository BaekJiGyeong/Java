package com.ktds.jgbaek;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddressBook {

	public void start() {

		Scanner userInput = new Scanner(System.in);
		int choice = 0;
		String searchName = "";
		AddressBookBiz biz = new AddressBookBiz();
		AddressInfoVO addressInfo = null;

		while (true) {
			System.out.println("주소를 등록하려면 1번, 주소를 찾으려면 2번");
			System.out.println("주소를 삭제하려면 3번, 프로그램을 종료하려면 4번을 입력해주세요.");
			choice = userInput.nextInt();

			if (choice == 1) {
				System.out.println("이름, 나이, 연락처, 주소를 순서대로 입력해 주세요.");
				addressInfo = new AddressInfoVO();
				while (true) {
					try {
						addressInfo.setName(userInput.next());
						break;
					} 
					catch (InputMismatchException ime) {
						System.out.println("나이는 정수로 입력해주세요.");
						userInput = new Scanner(System.in);
						break;
					}
				}
				addressInfo.setAge(userInput.nextInt());
				addressInfo.setPhoneNumber(userInput.next());
				addressInfo.setAddress(userInput.next());

				biz.addNewAddressBookInfo(addressInfo);
				System.out.println(addressInfo.getName() + "님의 주소록이 등록되었습니다.");

			}

			else if (choice == 2) {

				System.out.println("검색할 이름을 입력하세요");
				searchName = userInput.next();

				addressInfo = biz.getAddressInfoByName(searchName);

				System.out.println(addressInfo.getName());
				System.out.println(addressInfo.getAge());
				System.out.println(addressInfo.getPhoneNumber());
				System.out.println(addressInfo.getAddress());
			}

			else if (choice == 3) {
				System.out.println("삭제할 이름을 입력하세요");
				searchName = userInput.next();

				addressInfo = biz.getAddressInfoByName(searchName);
				biz.removeAddressBookInfo(addressInfo);
				System.out.println(searchName + "의 주소록이 삭제되었습니다.");
				continue;
			}

			else if (choice == 4) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("잘못 입력 하셨습니다.");
				continue;
			}
		}
	}

	public static void main(String[] args) {
		AddressBook addressBook = new AddressBook();
		addressBook.start();
	}

}
