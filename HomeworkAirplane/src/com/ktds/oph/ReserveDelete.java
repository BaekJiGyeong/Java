package com.ktds.oph;

public class ReserveDelete {
	
	public boolean choiceMenu(int choiceNumber, MakeReservation reservation, SeatsAirplane seatsAirplane) {
		
		System.out.println("열, 행으로 좌석을 입력하세요.");
		if ( choiceNumber == 1 ) {
			reserve(reservation, seatsAirplane);
			return true;
		}
		else if ( choiceNumber == 2 ) {
			delete(reservation, seatsAirplane);	
			return true;
		}
		else {
			System.out.println("메뉴를 다시 입력하세요.");
			return false;
		}
	}
	public void reserve(MakeReservation reservation, SeatsAirplane seatsAirplane) {
		
		int seat[];

		seatsAirplane.printSeat();
		seat = reservation.choiceSeat();
		if(seat!=null) {
			if (seatsAirplane.checkSeat(seat[0], seat[1])) {
				System.out.println("이미 예약된 좌석입니다.");
			} else {
				seatsAirplane.setSeat(seat[0], seat[1]);
			}
		}
		else {
			System.out.println("좌석번호를 다시 입력하세요.");
		}

	}
	
	public void delete(MakeReservation reservation, SeatsAirplane seatsAirplane){

		int seat[];

		seatsAirplane.printSeat();
		seat = reservation.choiceSeat();
		if(seat!=null) {
			if (seatsAirplane.checkSeat(seat[0], seat[1])) {
				seatsAirplane.deleteSeat(seat[0], seat[1]);
			} 
		}
		else {
			System.out.println("좌석번호를 다시 입력하세요.");
		}
	}
}
