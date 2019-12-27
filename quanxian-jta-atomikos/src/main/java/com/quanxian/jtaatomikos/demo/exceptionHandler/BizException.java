package com.quanxian.jtaatomikos.demo.exceptionHandler;

public class BizException extends RuntimeException {
	public BizException(String message) {
		super(message);
	}
}
