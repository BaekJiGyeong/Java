package com.ktds.oph;

import java.util.Scanner;

public class MakeReservation {
	
	private Scanner scanner;
	
	public void printMenu() {
		System.out.println("비행기 좌석을 예약합니다.");
		System.out.println("열, 행으로 좌석을 입력하세요.");
	}
	
	public int[] choiceSeat() {
		
		scanner = new Scanner(System.in);
		
		String seatNumber = scanner.nextLine();
		// 좌우 공백 제거
		seatNumber = seatNumber.trim();

		// 여분의 공백 제거 -> 1, 6 -> 1,6
		seatNumber = seatNumber.replace(" ", "");

		String seatNumbers[] = seatNumber.split(",");

		// 유효성 검사.
		if (seatNumbers.length != 2) {
			return null;
		}

		int row = parseInt(seatNumbers[0]);
		int cell = parseInt(seatNumbers[1]);

		if (row > SeatsAirplane.ROW-1 || cell > SeatsAirplane.CELL-1 || row < 0 || cell < 0) {
			return null;
		}

		return new int[] { row, cell };
	}
	
	private int parseInt(String seat) {
		
		try {
			return Integer.parseInt(seat);
			
		}
		catch (NumberFormatException nfe) {
			return -1;
		}
	}

}
