package com.wnxy.hospital.mims.exception;
//异常类
public class TestException extends RuntimeException{
	public TestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TestException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TestException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TestException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
