package com.mphasis.ams.login.exception;

import org.springframework.stereotype.Component;


@Component
public class BusinessException extends RuntimeException {

	public BusinessException(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private int code;
	private String message;
	
	public BusinessException(String message) {
		super();
		this.message = message;
	}
	
	public BusinessException(int code, String message,Throwable throwable) {
		super(throwable);
		this.code = code;
		this.message = message;
		
	}
	public BusinessException()
	{}

}
