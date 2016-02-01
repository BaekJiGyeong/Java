package com.ktds.oph.case3;

import java.util.ArrayList;
import java.util.List;


public class BookingBiz {

	private List<CustomerInfo> customerInfo;
	
	public BookingBiz(){
		customerInfo = new ArrayList<CustomerInfo>();
	}

	
	public List<CustomerInfo> getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(List<CustomerInfo> customerInfo) {
		this.customerInfo = customerInfo;
	}
	
	/**
	 * 사용자 등록
	 * @param customer
	 */
	public void enterCustomer(CustomerInfo customer) {
		customerInfo.add(customer);
	}

	/**
	 * 사용자 정보 지우기
	 * @param customer
	 */
	public void cancelSeat(CustomerInfo customer) {
		customerInfo.remove(customer);
		
	}
	
	/**
	 * 사용자의 좌석정보 가져오기
	 * @param name
	 * @return
	 */
	public int[] searchCustomerSeat(String name,List<CustomerInfo> customeri) {
		CustomerInfo customer = null;
		int seat[] = new int[2];
		
		customer = searchCustomer(name,customeri);
		
		seat = customer.getSeat();
		
		return seat;
	}
	
	/**
	 * 이름으로 사용자 정보 가져오기
	 * @param name
	 * @return
	 */
	public CustomerInfo searchCustomer(String name, List<CustomerInfo> customeri) {
		CustomerInfo customer = null;
		
		for (int i = 0; i < customeri.size(); i++) {
			customer = customeri.get(i);
			if(customer.getName().equals(name)){
				return customer;
			}
	
		}
		return new CustomerInfo();
	}
	

	
}
