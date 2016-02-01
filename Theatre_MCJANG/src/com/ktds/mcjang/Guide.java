package com.ktds.mcjang;

import java.util.Scanner;

public class Guide {

	public void printMenu() {
		System.out.println("열,행 으로 좌석을 입력하세요.");
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
	
	public boolean reserveSeat(Seats seats, int seatNumbers[]) {
		return seats.reserveSeat(seatNumbers);
	}
	
	
}















