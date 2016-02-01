package com.ktds.jgbaek;

import java.util.ArrayList;
import java.util.List;

/**
 * 전화번호부가 가져야하는 기능들을 정의한다.
 * 
 * Create : 생성 Read : 찾기 혹은 상세보기 Update : 수정하기 Delete : 삭제하기 ========= CRUD 라고
 * 한다.
 * 
 * @author 206-008
 *
 */

public class PhoneBookBiz {

	private List<PhoneInfoVO> phoneInfoList;

	public PhoneBookBiz() { // 생성자
		this.phoneInfoList = new ArrayList<PhoneInfoVO>();
	}

	public List<PhoneInfoVO> getPhoneInfoList() {
		return phoneInfoList;
	}

	public void setPhoneInfoList(List<PhoneInfoVO> phoneInfoList) {
		this.phoneInfoList = phoneInfoList;
	}

	/**
	 * Create
	 * @param phoneInfo
	 */
	public void addNewPhoneBookInfo(PhoneInfoVO phoneInfo) {
		this.phoneInfoList.add(phoneInfo);

	}
	
	/**
	 * Read
	 * @param name
	 * @return
	 */
	public PhoneInfoVO getPhoneInfoByName( String name ) {
		for ( PhoneInfoVO phoneInfo : this.phoneInfoList) {
			if ( phoneInfo.getName().equals(name)){
				return phoneInfo;
				}
			
		}
		// 리스트에 검색한 결과가 없을 때는 새로운 인스턴스를 만들어 리턴한다.
		return new PhoneInfoVO();
	}

}
