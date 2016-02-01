package com.ktds.jgbaek;

import java.util.Scanner;

public class CancelSystem {

	Scanner input = new Scanner(System.in);

	private String name;

	CustomerVO info;

	public void start(AirplaneBiz biz) {

		while (true) {

			System.out.println("사용자 이름을 입력하세요.");
			name = input.next();

			if (!biz.isAddressEmpty(name)) {
				info = biz.returnBicycleRentalInfo(name);
				break;
			} else {
				System.out.println("없습니다.");
			}
		}
		int row = info.getSeatRow();
		int col = info.getSeatCol();
		biz.seat.deleteSeat(row, col);
		System.out.println(name+"님 비행기 예약이 취소되셨습니다.");		
		biz.removeInfo(info);

	}

}
