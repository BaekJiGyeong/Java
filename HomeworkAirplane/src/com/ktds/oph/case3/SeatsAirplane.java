package com.ktds.oph.case3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatsAirplane {
	

	public static final int ROW = 2;
	public static final int CELL = 8;
	

	private Map<Integer, List<String>> seats;
		
	public SeatsAirplane() {
		// 좌석 만들기
		seats = new HashMap<Integer, List<String>>();
		
		List<String> seat = null;
		for (int i = 0; i < ROW; i++) {
			seat = new ArrayList<String>();
			
			
			for (int j = 0; j < CELL; j++) {
				seat.add("○");
			}
			
			seats.put(i, seat);
		}
		
	}
	
	public Map<Integer, List<String>> getSeats() {
		return seats;
	}
	
	public void setSeats(Map<Integer, List<String>> seats) {
		this.seats = seats;
	}
	
	/**
	 * 좌석 출력하기
	 */
	public void printSeat() {
		List<String> seat = null;
		for (int i = 0; i < ROW; i++) {
			
			seat = seats.get(i);
			
			for ( String seatPrint : seat ) {
				System.out.print(seatPrint);
			}
			System.out.println();
		}		
	}
	
	/**
	 * 해당 좌석 예약 유무 확인
	 * 예약 된 좌석이면 T, 빈자리면 F
	 * @param row
	 * @param cell
	 */
	public boolean checkSeat(int row, int cell) {
		List<String> checkSeat = null;
		checkSeat = seats.get(row);
		String check = checkSeat.get(cell);
		
		if (check.equals("●")) {
			
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setSeat(int row, int cell) {
		List<String> checkSeat = null;
		checkSeat = seats.get(row);
		
		checkSeat.set(cell, "●");
		
	}
	
	public void deleteSeat(int row, int cell) {
		List<String> checkSeat = null;
		checkSeat = seats.get(row);
		
		checkSeat.set(cell, "○");
	}
	
	/**
	 * 좌석이 전부 예약 됐는지 확인한다.
	 * 다 예약 됐으면 T, 빈자리 있으면 F
	 * @return
	 */
	public boolean isFullBooking() {
		
		List<String> seat = null;
		int reserveCount = 0;
		
		for ( int i = 0; i < ROW; i++ ) {
			seat = seats.get(i);
			for ( String s : seat ) {
				if ( s.equals("●") ) {
					reserveCount++;
				}
			}
		}
		
		return reserveCount == ROW*CELL;
	}
	

}
