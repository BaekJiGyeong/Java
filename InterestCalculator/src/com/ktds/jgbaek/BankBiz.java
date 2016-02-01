package com.ktds.jgbaek;

import java.util.ArrayList;
import java.util.List;

public class BankBiz {

	private List<BankVO> bankBook;
	private UserInput input;
	private ApplyLoan applyLoan;
	private PayBack payBack;
	private Bankruptcy bankruptcy;
	
	private long bankMoney=1000000000;
	
	private String name;
	private long money;
	

	public BankBiz() {
		this.bankBook = new ArrayList<BankVO>();
		this.input = new UserInput();
		this.applyLoan = new ApplyLoan();
		this.payBack = new PayBack();
		this.bankruptcy = new Bankruptcy();
		
		this.name = "";
	}
	
	public List<BankVO> getBankBook() {
		return bankBook;
	}
	
	public void setBankBook(List<BankVO> bankBook){
		this.bankBook = bankBook;
	}
	
	public void addLoanInfo(String name, String phoneNumber, long loan, String guarantee, int date) {
		BankVO info = new BankVO();
		info.setName(name);
		info.setPhoneNumber(phoneNumber);
		info.setLoan(loan);
		info.setGuarantee(guarantee);
		info.setDate(date);
		
		this.bankBook.add(info);
	}
	
	public long getBankMoney() {
		return bankMoney;
	}

	public void setBankMoney(long bankMoney) {
		this.bankMoney = bankMoney;
	}
	
	public void printBankMoney () {
		System.out.println("은행의 잔고는 " + this.bankMoney+ "원 입니다.");
	}
	
	public void removeLoanInfo(BankVO info) {
		this.bankBook.remove(info);
	}
	
	public BankVO returnBankInfo ( String name ){
		for (BankVO vo : this.getBankBook()) {
			if (vo.getName().equals(name)) {
				return vo;
			}
		}
		return new BankVO();
	}

	public void startProgram() {

		while (true) {
			System.out.println("<<대출은행>>");
			this.printBankMoney();
			System.out.println("1:대출 2:갚기 3:파산 Exit:종료");
			String userWant = input.inputString();
			
			if (userWant.equals("1")) {
				applyLoan.go(this);
			} else if (userWant.equals("2")) {
				payBack.go(this);
			} else if ( userWant.equals("3")){
				bankruptcy.go(this);
			} else if (userWant.equalsIgnoreCase("Exit")) {
				System.out.println("은행을 나옵니다.");
				System.exit(0);
			} else {
				System.out.println("정확하게 입력해주세요.");
			}
		}
	}
	
	public boolean isAddressEmpty(String name) {

		for (BankVO vo : this.getBankBook()) {
			if (vo.getName().equals(name)) {
				return false;
			}
		}
		return true;
	}
	
	public void loanBank(long money){
		bankMoney = bankMoney - money;
	}
	
	public void payBack(long money) {
		bankMoney = bankMoney+money;
	}
	
	public long interestCalculator( long money, int nowDate, int userDate ) {
		int addInterestMoney = 0;
		int spendTime = (nowDate - userDate);
		addInterestMoney = (int) ( Math.pow(1.1,((spendTime-(spendTime%5))/5))*money);
		return addInterestMoney;
	}

}
