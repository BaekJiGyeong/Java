package com.ktds.jgbaek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Theater {

	public void start() {

		Map<Integer, List<String>> seats = new HashMap<Integer, List<String>>();

		//좌석 만들기
		List<String> seat = null;
		for (int j = 0; j < 5; j++) {
			
			seat = new ArrayList<String>();
			
			for (int i = 0; i < 10; i++) {
				seat.add("□");
			}
			
			seats.put(j, seat); // 5줄 1줄당 10좌석 : 총 50좌석			
		}
		
		// 좌석 출력하기
		for(int i=0; i<5; i++) {
			seat = seats.get(i); // 10개의 좌석이 들어있음
			
			for ( String s : seat) {
				System.out.print(s);
			}
			System.out.println("");
		}
		
		String seatNumber = "1,6";
		
		// 좌우 공백 제거
		seatNumber = seatNumber.trim();
		//여분의 공백 제거
		seatNumber = seatNumber.replace(" ","");
		
		//, 기준으로 자르기
		String seatNumbers[] = seatNumber.split(","); // 앞글자는 0인덱스 뒷글자는 1인덱스
		
		int row = Integer.parseInt(seatNumbers[0]);
		int cell = Integer.parseInt(seatNumbers[1]);
		
		
		// 좌석 예매하기
		// 0번 줄의 5번째 좌석을 예매한다.
		List<String> selectedSeats = seats.get(row);
		selectedSeats.set(cell,"■");
		
		for(int i=0; i<5; i++) {
			seat = seats.get(i); // 10개의 좌석이 들어있음
			
			for ( String s : seat) {
				System.out.print(s);
			}
			System.out.println("");
		}

	}

	public static void main(String[] args) {

		Theater theater = new Theater();
		theater.start();

	}

}
