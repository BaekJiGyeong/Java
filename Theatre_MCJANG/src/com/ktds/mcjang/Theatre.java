package com.ktds.mcjang;

public class Theatre {

	public void start() {
		
		Seats seats = new Seats();
		Guide guide = new Guide();
		
		while (true) {
			
			seats.printSeats();
			
			if(seats.isFullReserve()) {
				System.out.println("빈 자리가 없습니다. 프로그램을 종료합니다.");
				break;
			}
			
			guide.printMenu();
			
			int[] seatNumbers = guide.choiceSeat();
			
			if (seatNumbers == null) {
				System.out.println("잘못 입력했습니다. 다시 입력하세요.");
				continue;
			}
			
			if (guide.reserveSeat(seats, seatNumbers) ) {
				System.out.println("예약에 성공했습니다.");
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Theatre theatre = new Theatre();
		theatre.start();
		
	}
	
}
