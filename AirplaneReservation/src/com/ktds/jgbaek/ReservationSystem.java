package com.ktds.jgbaek;

import java.util.Date;
import java.util.Scanner;

public class ReservationSystem {	

	public void start(AirplaneBiz biz) {
		Date date = new Date();

		while (true) {

			biz.seat.printSeat();
			
			if (biz.seat.isFullReserve()) {
				System.out.println("빈 자리가 없습니다. 프로그램을 종료합니다.");
				break;
			}
			
			System.out.println("열, 행 으로 좌석을 입력하세요.");				
			int[] seatNumbers = choiceSeat();
			
			if (seatNumbers == null) {
				System.out.println("잘못 입력했습니다. 다시 입력하세요.");
				continue;
			}
			
			System.out.println("성함을 입력해주세요.");
			String name = biz.inputName();
			
			if (reserveSeat(biz.seat, seatNumbers) ) {
				System.out.println("예약에 성공했습니다."+date.toLocaleString());
				biz.addReserveInfo(name, seatNumbers[0], seatNumbers[1], date.toLocaleString());
				break;
			}
		}
		
		
		System.out.println();

	}
	
	public int[] choiceSeat() {
		Scanner input = new Scanner( System.in );
		String seatNumber = input.next();
		
		// 좌우 공백 제거
		seatNumber = seatNumber.trim();
		
		// 여분의 공백 제거 -> 1, 6 -> 1,6
		seatNumber = seatNumber.replace(" ", "");

		String seatNumbers[] = seatNumber.split(",");
		
		// 유효성 검사.
		if ( seatNumbers.length != 2 ) {
			return null;
		}
		
		int row = Integer.parseInt(seatNumbers[0]);
		int cell = Integer.parseInt(seatNumbers[1]);
		
		if ( row > 9 || cell > 9 ) {
			return null;
		}
		
		return new int[]{row, cell};
	}
	
	public boolean reserveSeat(Seat seats, int seatNumbers[]) {
		return seats.reserveSeat(seatNumbers);
	}

}
