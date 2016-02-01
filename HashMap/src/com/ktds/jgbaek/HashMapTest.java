package com.ktds.jgbaek;

public class HashMapTest {
	
	public void start() {
		DictionaryProgram program = new DictionaryProgram();
		
		// 프로그램의 인사
		program.Hello();
		
		// 프로그램의 메인부분
		program.DictionaryExcution();
	}


	public static void main(String[] args) {

		HashMapTest map = new HashMapTest();
		map.start();
	}
}
