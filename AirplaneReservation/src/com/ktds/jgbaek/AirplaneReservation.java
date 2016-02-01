package com.ktds.jgbaek;

public class AirplaneReservation {
	
	public void start() {
		
		AirplaneBiz biz = new AirplaneBiz();
		biz.start();		
		
	}
	
	public static void main(String[] args) {
		AirplaneReservation reservation = new AirplaneReservation();
		reservation.start();
	}

}
