package com.ktds.jgbaek;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class DictionaryProgram {

	private Map<String, String> dictionary;
	private Scanner console;

	private int flag = 0;
	private String english = "";
	private String korean = "";

	public DictionaryProgram() { // 생성자
		dictionary = new HashMap<String, String>();
		console = new Scanner(System.in);
	}

	public void DictionaryExcution() {

		while (true) {

			Menu();
			
			while (true) {
				try {
					flag = console.nextInt();
					console = new Scanner(System.in);
					break;
				} 
				catch (InputMismatchException ime) {
					System.out.println("잘못 입력했습니다.");
					Menu();
					console = new Scanner(System.in);
				}
			}

			if (flag == 1) {
				addWord();
			} else if (flag == 2) {
				searchWord();
			} else if (flag == 3) {
				removeWord();
			} else if (flag == 9) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("숫자 1, 2, 3, 9중 하나를 입력하세요.");
			}
		}
	}

	public void Hello() {

		System.out.println("----------------------------------");
		System.out.println("             간단 단어장");
		System.out.println("----------------------------------");
	}

	public void Menu() {

		System.out.println("******메뉴를 선택하세요******");
		System.out.println("1. 단어 등록");
		System.out.println("2. 단어 조회");
		System.out.println("3. 단어 삭제");
		System.out.println("9. 종료");

	}

	public void addWord() {

		System.out.println("등록하고 싶은 영어 단어를 입력하세요.");
		english = console.nextLine();
		System.out.println("등록한 영어의 뜻을 한국어로 입력하세요.");
		korean = console.nextLine();

		dictionary.put(english, korean);
		System.out.println("단어를 등록했습니다.");

	}

	public void searchWord() {
		
		System.out.println("찾고싶은 영어 단어를 입력하세요.");
		english = console.nextLine();

		korean = dictionary.get(english);
		
		if (korean == null) {
			System.out.println("해당 단어는 존재하지 않습니다.");
		} else {
			System.out.println(english + "의 뜻은 " + korean + "입니다.");
		}
	}

	public void removeWord() {
		System.out.println("삭제하고 싶은 영어 단어를 입력하세요.");
		english = console.nextLine();

		// Map에서 단어를 가져옴.
		korean = dictionary.get(english);
		if (korean == null) {
			System.out.println("해당 단어는 존재하지 않습니다.");
		} else {
			// Map에서 단어를 삭제함.
			dictionary.remove(english);
			System.out.println(english + "를(을) 삭제했습니다.");
		}
	}
}