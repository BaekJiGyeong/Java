package com.ktds.mcjang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Seats {

	private Map<Integer, List<String>> seats;
	
	public Seats() {
		seats = new HashMap<Integer, List<String>>();
		
		// 좌석 만들기
		List<String> seat = null;
		for ( int j = 0; j < 5; j++ ) {
			seat = new ArrayList<String>();
			
			for ( int i = 0; i < 10; i++ ) {
				seat.add("□");
			}
			seats.put(j, seat);
		}
	}
	
	public void printSeats() {
		List<String> seat = null;
		
		for ( int i = 0; i < 5; i++ ) {
			seat = seats.get(i);
			
			for ( String s : seat ) {
				System.out.print(s);
			}
			System.out.println("");
		}
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
		
		for ( int i = 0; i < 5; i++ ) {
			seat = seats.get(i);
			for ( String s : seat ) {
				if ( s.equals("■") ) {
					reserveCount++;
				}
			}
		}
		
		return reserveCount == 50;
	}
	
}
