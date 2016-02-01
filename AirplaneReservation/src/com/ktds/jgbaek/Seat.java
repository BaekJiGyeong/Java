package com.ktds.jgbaek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Seat {

	private Map<Integer, List<String>> seats;
	
	public Seat() {
		seats = new HashMap<Integer, List<String>>();
		
		// 좌석 만들기
		List<String> seat = null;
		for ( int j = 0; j < 2; j++ ) {
			seat = new ArrayList<String>();
			
			for ( int i = 0; i < 10; i++ ) {
				seat.add("○");
			}
			seats.put(j, seat);
		}
	}
	
	public void printSeat() {
		List<String> seat = null;
		
		for ( int i = 0; i < 2; i++ ) {
			seat = seats.get(i);
			
			for ( String s : seat ) {
				System.out.print(s);
			}
			System.out.println("");
		}
	}
	
	public void deleteSeat(int row, int col) {
		List<String> checkSeat = null;
		checkSeat = seats.get(row);
		
		checkSeat.set(col, "○");
	}
	
	public boolean reserveSeat(int seatNumbers[]) {
		
		// 좌석 예매하기
		// 0번 줄의 5번째 좌석을 예매한다.
		List<String> selectedSeats = seats.get(seatNumbers[0]);
		
		if ( selectedSeats.get(seatNumbers[1]).equals("■") ) {
			System.out.println("이미 예약된 좌석입니다.");
			return false;
		}
		else {
			selectedSeats.set(seatNumbers[1], "■");
			return true;
		}
	}
	
	public boolean isFullReserve() {
		
		List<String> seat = null;
		int reserveCount = 0;
		
		for ( int i = 0; i < 2; i++ ) {
			seat = seats.get(i);
			for ( String s : seat ) {
				if ( s.equals("■") ) {
					reserveCount++;
				}
			}
		}
		
		return reserveCount == 20;
	}
	
}
