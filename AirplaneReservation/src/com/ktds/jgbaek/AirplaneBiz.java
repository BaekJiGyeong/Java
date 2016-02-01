package com.ktds.jgbaek;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirplaneBiz {

	Scanner userInput = new Scanner(System.in);

	List<CustomerVO> customerInfo;
	ReservationSystem reservationSystem;
	CancelSystem cancelSystem;
	Seat seat;

	private int userWant;

	public AirplaneBiz() {
		this.customerInfo = new ArrayList<CustomerVO>();
		this.reservationSystem = new ReservationSystem();
		this.cancelSystem = new CancelSystem();
		this.seat = new Seat();
	}

	public List<CustomerVO> getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(List<CustomerVO> customerInfo) {
		this.customerInfo = customerInfo;
	}

	public void addReserveInfo(String name, int seatRow, int seatCol, String date) {
		CustomerVO info = new CustomerVO();
		info.setName(name);
		info.setSeatRow(seatRow);
		info.setSeatCol(seatCol);
		info.setDate(date);
		this.customerInfo.add(info);
	}

	public void removeInfo(CustomerVO info) {
		this.customerInfo.remove(info);
	}

	public CustomerVO returnBicycleRentalInfo(String name) {

		for (CustomerVO vo : this.getCustomerInfo()) {
			if (vo.getName().equals(name)) {
				return vo;
			}
		}
		return new CustomerVO();
	}

	public void start() {

		while (true) {

			System.out.println("======================");
			System.out.println("    비행기예약시스템");
			System.out.println("======================");
			seat.printSeat();
			System.out.println("1:예약 2:취소");
			userWant = userInput.nextInt();

			if (userWant == 1) {
				reservationSystem.start(this);
			} else if (userWant == 2) {
				cancelSystem.start(this);
			} else {
				System.out.println("정확히 입력해주세요.");
			}
		}
	}

	public String inputName() {
		Scanner name = new Scanner(System.in);
		String userName = name.next();
		return userName;
	}

	public boolean isAddressEmpty(String name) {

		for (CustomerVO vo : this.getCustomerInfo()) {

			if (vo.getName().equals(name)) {
				return false;
			}
		}
		return true;
	}
}
