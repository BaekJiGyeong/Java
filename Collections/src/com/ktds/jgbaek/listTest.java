package com.ktds.jgbaek;

import java.util.ArrayList;
import java.util.List;

public class listTest {

	public void start() {

		List<String> list = new ArrayList<String>();

		list.add("김광민");
		list.add("김현섭");
		list.add("이기연");
		list.add("김하늘");
		list.add("양지한");

		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));

		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("이기연")) {
				System.out.println("이기연을 찾았습니다.");
				break;
			}
		}

		for (String name : list) {
			if (name.equals("이기연")) {
				System.out.println("이기연을 찾았습니다.");
				break;
			}
		}

		if (list.contains("이기연")) {
			System.out.println("이기연을 찾았습니다.");
		}

		System.out.println(list.indexOf("이기연")); // 존재하면 인덱스 번호 출력
		System.out.println(list.indexOf("남준호")); // 존재하지 않으면 -1 출력

		String name = list.get(list.indexOf("이기연")); // 이름 가져오는 방법
		System.out.println(name);
		
		list.set(2,  "조민제");
		System.out.println(list.get(2));
		System.out.println(list.size());
		
		list.remove(2); // 내가 지우고 싶은 데이터의 인덱스를 알때
		list.remove("조민제"); // 내가 지우고 싶은 데이터를 다 지워줌
		
		
	}

	public static void main(String[] args) {

		listTest test = new listTest();
		test.start();

	}

}
