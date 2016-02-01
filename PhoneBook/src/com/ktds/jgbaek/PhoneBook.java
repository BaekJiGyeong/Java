package com.ktds.jgbaek;

import java.util.Scanner;

public class PhoneBook {

	public void start() {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		String searchName = "";
		PhoneInfoVO phoneInfo = null;
		PhoneBookBiz biz = new PhoneBookBiz();

		while (true) {
			System.out.println("등록하려면 1번, 찾기하려면 2번");
			choice = input.nextInt();

			if (choice == 1) {

				System.out.println("이름과 전화번호 나이를 순서대로 입력하세요.");

				phoneInfo = new PhoneInfoVO();
				phoneInfo.setName(input.next());
				phoneInfo.setPhoneNumber(input.next());
				phoneInfo.setAge(input.nextInt());
				
				biz.addNewPhoneBookInfo(phoneInfo);
				
			} 
			else if (choice == 2) {
				System.out.println("검색할 이름을 입력하세요.");
				searchName = input.next();
				
				phoneInfo = biz.getPhoneInfoByName(searchName);
				System.out.println(phoneInfo.getName());
				System.out.println(phoneInfo.getPhoneNumber());
				System.out.println(phoneInfo.getAge());
			} 
			else {
				break;
			}
		}
	}

	public static void main(String[] args) {
		PhoneBook phoneBook = new PhoneBook();
		phoneBook.start();
	}

}
