package com.ktds.oph.case3;

import java.util.Scanner;

public class ReserveDelete {

	public boolean choiceMenu(int choiceNumber, MakeReservation reservation, SeatsAirplane seatsAirplane, CustomerInfo customerInfo, BookingBiz booking) {
		
		if ( choiceNumber == 1 ) {
			//사용자 정보입력
			reserve(customerInfo, reservation, seatsAirplane,booking);
			return true;
		}
		else if ( choiceNumber == 2 ) {
			delete(customerInfo,seatsAirplane,booking);	
			return true;
		}
		else if ( choiceNumber == 3) {
			searchCustomerInfo(customerInfo, booking);
			return true;
		}
		else {
			System.out.println("메뉴를 다시 입력하세요.");
			return false;
		}
	}
	

	
	private void reserve(CustomerInfo customerInfo, MakeReservation reservation, SeatsAirplane seatsAirplane,BookingBiz booking) {
		Scanner scanner = new Scanner(System.in);
		customerInfo = new CustomerInfo();
		System.out.println("이름을 입력하세요.");
		customerInfo.setName(scanner.nextLine());
		customerInfo.setDate(GetToday.getNowTime());
		
		int seat[];

		seatsAirplane.printSeat();
		System.out.println("좌석 번호를 입력하세요.");
		seat = reservation.choiceSeat();
		if(seat!=null) {
			if (seatsAirplane.checkSeat(seat[0], seat[1])) {
				System.out.println("이미 예약된 좌석입니다.");
			} else {
				seatsAirplane.setSeat(seat[0], seat[1]);
				customerInfo.setSeat(seat);
				booking.enterCustomer(customerInfo);
			}
		}
		else {
			System.out.println("좌석번호를 다시 입력하세요.");
		}
		

	}
	
	
	private void delete(CustomerInfo customerInfo, SeatsAirplane seatsAirplane, BookingBiz booking){
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름을 입력하세요.");
		String name = scanner.nextLine();
		int seat[] = booking.searchCustomerSeat(name, booking.getCustomerInfo() );

		seatsAirplane.printSeat();

		if(seat!=null) {
			if (seatsAirplane.checkSeat(seat[0], seat[1])) {
				seatsAirplane.deleteSeat(seat[0], seat[1]);
				booking.cancelSeat(booking.searchCustomer(name,booking.getCustomerInfo()));
			} 
		}
		else {
			System.out.println("이름을 다시 입력하세요.");
		}
	}
	
	private void searchCustomerInfo(CustomerInfo customerInfo, BookingBiz booking){
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름을 입력하세요.");
		String name = scanner.nextLine();
		
		customerInfo = new CustomerInfo();
		customerInfo = booking.searchCustomer(name,booking.getCustomerInfo());
		if (customerInfo.getName()!=null){
			System.out.print("이름 : ");
			System.out.println(customerInfo.getName());
			System.out.print("날짜 : ");
			System.out.println(customerInfo.getDate());
		}
		else {
			System.out.println("예약자 명단에 없습니다.");
		}
	}
}
