package com.ktds.jgbaek;

import java.util.ArrayList;
import java.util.List;

public class AddressBookBiz {

	private List<AddressInfoVO> addressInfoList;

	public AddressBookBiz() { // 생성자
		this.addressInfoList = new ArrayList<AddressInfoVO>();
	}

	public List<AddressInfoVO> getAddressInfoList() {
		return addressInfoList;
	}

	public void setAddressInfoList(List<AddressInfoVO> addressInfoList) {
		this.addressInfoList = addressInfoList;
	}

	public void addNewAddressBookInfo(AddressInfoVO addressInfo) {
		this.addressInfoList.add(addressInfo);
	}

	public AddressInfoVO getAddressInfoByName(String name) {
		for (AddressInfoVO addressInfo : this.addressInfoList) {
			if (addressInfo.getName().equals(name)) {
				return addressInfo;
			}
		}

		return new AddressInfoVO();
	}

	public void removeAddressBookInfo(AddressInfoVO addressInfo) {
		this.addressInfoList.remove(addressInfo);
	}
}
