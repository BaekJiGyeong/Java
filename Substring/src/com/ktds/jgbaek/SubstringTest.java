package com.ktds.jgbaek;

public class SubstringTest {
	
	private void start() {
		
		String welcome = "Hello, World!";
		System.out.println(welcome);
		
		System.out.println(welcome.length());
		String world = welcome.substring(7, 13); // 0이외의 숫자 쓰지말자 //lastindexof, lenghthof
		//공백 다음부터 마지막까지
		world = welcome.substring(welcome.indexOf(" ") + 1, welcome.length() );
		System.out.println(world);
		
//		String hello = welcome.substring(0, welcome.indexOf(","));
//		hello = welcome.substring(0, "hello".length());
//		System.out.println(hello);
//		
//		world = welcome.substring( welcome.indexOf(" ")+1); // 공백부터 끝까지 다 ( 목적지 안적어 줄시에)
//		System.out.println(world);
//		
//		String str = welcome.substring(4,8);
//		System.out.println(str);
//		
//		str = welcome.substring(welcome.indexOf("o"));
//		System.out.println(str);
//		
//		str = welcome.substring(welcome.lastIndexOf("o"));
//		System.out.println(str);
//		
//		String id = welcome.substring(0,3);
//		for ( int i=0; i<5; i++ ) {
//			id += "*";
//		}
//		System.out.println(id);
	
	}
	
	public static void main(String[] args) {
		SubstringTest substringTest = new SubstringTest();
		substringTest.start();
	}

}
