package com.quanxian.readwrite.demo.exceptionHandler;

public class BizException extends RuntimeException {
	public BizException(String message) {
		super(message);
	}
}
