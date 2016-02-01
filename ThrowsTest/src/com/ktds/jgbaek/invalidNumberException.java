package com.ktds.jgbaek;

public class invalidNumberException extends RuntimeException { //exception이라서 try catch 의무가 있음

	public invalidNumberException() {
		super();
	}

	public invalidNumberException(String msg) {
		super(msg);
	}

	public invalidNumberException(Throwable t) { // 최상위 예외 클래스 모든 예외를 다포함
		super(t);
	}

	public invalidNumberException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
