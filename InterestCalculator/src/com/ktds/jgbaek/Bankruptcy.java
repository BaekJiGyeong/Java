package com.ktds.jgbaek;

public class Bankruptcy {
	
	UserInput input = new UserInput();

	private String name;
	private String phoneNumber;
	private long loan;
	private String guarantee;
	private int userDate;
	
	BankVO info;
	
	public void go(BankBiz biz) {
		while (true) {
			System.out.println("성함을 입력하세요.");
			name = input.inputString();

			if (!biz.isAddressEmpty(name)) {
				info = biz.returnBankInfo(name);
				break;
			} else {
				System.out.println("없습니다.");
			}
		}
		System.out.println(name+ "님 파산신청 완료되셨습니다.");
		biz.removeLoanInfo(info);
	}
	

}
