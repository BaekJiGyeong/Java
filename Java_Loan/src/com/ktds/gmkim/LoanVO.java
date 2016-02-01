package com.ktds.gmkim;

public class LoanVO {

//	변수 선언
	private long money;
	private long loanMoney;
	private long mil;
	
	private String name;
	private String phoneNumber;
	private String security;
	
	/**
	 * 기본 생성자 
	 */
	public LoanVO() {
		
		money = 100000000L;
		loanMoney = 0L;
		
		name = "";
		phoneNumber = ""; 
		security = "";
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long userMoney) {
		this.money = userMoney;
	}

	public long getLoanMoney() {
		return loanMoney;
	}

	public void setLoanMoney(long loanMoney) {
		this.loanMoney = loanMoney;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}
	
	public long getMil() {
		return this.mil;
	}
	
	public void setMil( long mil ) {
		this.mil = mil;
	}
	
	public void addMoney( long money ) {
		this.money += money;
	}
}
