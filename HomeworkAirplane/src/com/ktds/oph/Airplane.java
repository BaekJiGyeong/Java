package com.ktds.oph;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Airplane {
	
	private Scanner scanner;
	
	public void start() {
		MakeReservation reservation = new MakeReservation();
		SeatsAirplane seatsAirplane = new SeatsAirplane();
		ReserveDelete reserveDelete = new ReserveDelete();
		
		reservation.printMenu();
		seatsAirplane.printSeat();
		
		int choiceNumber = 0;
		
		while (true) {
			
		
			if (seatsAirplane.isFullBooking()){
				System.out.println("모든 좌석이 예약 완료.");
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			System.out.println("예약을 하시려면 1번을");
			System.out.println("삭제를 하시려면 2번을 선택하세요.");
			System.out.println("===============================");
			
			scanner = new Scanner(System.in);
			try {
				choiceNumber = scanner.nextInt();
			}
			catch (InputMismatchException ime) {
				System.out.println("숫자를 입력하세요.");
				continue;
			}
			if(!reserveDelete.choiceMenu(choiceNumber, reservation, seatsAirplane)) {
				continue;
			}

			seatsAirplane.printSeat();
			
		}

	}

	
	public static void main(String[] args) {
		Airplane airplane = new Airplane();
		airplane.start();
		
	}

}
