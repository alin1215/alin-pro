package com.quanxian.demo.exceptionHandler;

public class BizException extends RuntimeException {
	public BizException(String message) {
		super(message);
	}
}
