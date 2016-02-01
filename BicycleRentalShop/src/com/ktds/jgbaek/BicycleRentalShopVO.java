package com.ktds.jgbaek;

public class BicycleRentalShopVO {
	
	private String name;
	private int bicycle;
	private long date;
	
	public BicycleRentalShopVO () {
		name = "";
		bicycle = 0;
		date = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBicycle() {
		return bicycle;
	}

	public void setBicycle(Integer bicycle) {
		this.bicycle = bicycle;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	
	

}
