package com.mphasis.ams.login.exception;

import org.springframework.stereotype.Component;

@Component
public class ExceptionResponse {

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
	private int code;
	private String message;
	

}
