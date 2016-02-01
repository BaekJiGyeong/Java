package com.ktds.jgbaek;

import java.util.Calendar;

public class PayBack {
	
	UserInput input = new UserInput();

	private String name;
	private String phoneNumber;
	private long loan;
	private String guarantee;
	private int userDate;
	
	private int nowDate;	
	private long payBackMoney;
	private long addInterestMoney;
	
	BankVO info;
	
	public void go(BankBiz biz) {
		while (true) {
			System.out.println("사용자 이름을 입력하세요.");
			name = input.inputString();

			if (!biz.isAddressEmpty(name)) {
				info = biz.returnBankInfo(name);
				break;
			} else {
				System.out.println("없습니다.");
			}
		}
		
		loan = info.getLoan();
		userDate = info.getDate();
		
		Calendar now = Calendar.getInstance();
		nowDate = (int) (now.getTimeInMillis()/1000);
		
		System.out.println("nowDate"+nowDate);
		
		addInterestMoney = biz.interestCalculator(loan,nowDate,userDate);
		
		System.out.println("현재 갚으실 금액은 원금 "+loan+"원에서 이자붙은 금액 "+addInterestMoney+"원 입니다.");
		
		System.out.println("갚으실 금액을 입력해주세요.");
		payBackMoney = input.inputInt();
		
		biz.payBack(payBackMoney);
		info.setLoan(addInterestMoney-payBackMoney);
		if ( info.getLoan() != 0 ) {
			info.setDate(nowDate);
		}
		else {
			System.out.println("전부 상환하셨습니다. 담보 " + info.getGuarantee()+"를 돌려받았습니다.");
			biz.removeLoanInfo(info);
		}
		
	}
	
}
