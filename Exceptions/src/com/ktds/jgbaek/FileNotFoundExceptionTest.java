package com.ktds.jgbaek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileNotFoundExceptionTest {
	public void start() {
		
		File file = new File("D:\\test123.ddd");
//		InputStream is1 = new FileInputStream(file); // error가 발생할 확률이 높으니 잡고 시작해라
		try {
			InputStream is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // add throws declaration <- 예외처리 책임 전가 //surround with try/catch <- 자신이 잡음
	}
	
	public static void main(String[] args) {
		FileNotFoundExceptionTest test = new FileNotFoundExceptionTest();
		test.start();
	}

}
