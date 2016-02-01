package com.ktds.jgbaek;

import java.util.Calendar;
import java.util.Date;

public class ApplyLoan {

	UserInput input = new UserInput();
	Date today = new Date();

	private String name;
	private String phoneNumber;
	private long loan;
	private String guarantee;
	private int date;

	BankVO info;

	public void go(BankBiz biz) {

		System.out.println("성함을 입력하세요");
		name = input.inputString();

		System.out.println("핸드폰 번호를 입력하세요");
		phoneNumber = input.inputString();
		System.out.println("대출 금액을 입력하세요");

		if (biz.getBankMoney() < loan) {
			System.out.println("은행에 돈이 없습니다.");
			System.exit(0);
		} else {

			loan = input.inputInt();
			System.out.println("담보를 입력하세요");
			guarantee = input.inputString();
			System.out.println(today.toLocaleString() + "에 빌리셨습니다.");
			Calendar now = Calendar.getInstance();
			date = (int) (now.getTimeInMillis() / 1000);

			System.out.println("userTime" + date);

			biz.addLoanInfo(name, phoneNumber, loan, guarantee, date);
			biz.loanBank(loan);
		}
	}

}
