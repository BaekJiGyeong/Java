package com.ktds.oph.case3;

/**
 * 예약한 사람의 정보입니다. VO
 * @author 206-024
 *
 */
public class CustomerInfo {
	
	private String name;
	private String date;
	private int seat[];

	
	public int[] getSeat() {
		return seat;
	}
	public void setSeat(int[] seat) {
		this.seat = seat;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
