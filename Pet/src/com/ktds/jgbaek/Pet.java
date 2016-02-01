package com.ktds.jgbaek;
/**
 * 애완동물의 정보를 가지는 클래스
 */
public class Pet {
	
	/**
	 * 만들 수 있는 애완동물의 수
	 */
	public static int petCount = 2;
	
	/**
	 * 애완 동물의 종류
	 */
	private String type;
	
	/**
	 * 애완 동물의 이름
	 */
	private String name;
		
	public void setType ( String type ){
		this.type = type;
	}
	
	public void setName ( String name ){
		this.name = name;
	}
	
	public String getType ( ) {
		return this.type;
	}
	
	String getName ( ) {
		return this.name;
	}
	
}