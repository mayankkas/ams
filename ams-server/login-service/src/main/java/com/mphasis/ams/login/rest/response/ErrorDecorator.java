package com.mphasis.ams.login.rest.response;

public class ErrorDecorator {

	public ErrorDecorator(String errorCode, String errorFieldName, String errorDescription) {
		super();
		this.errorCode = errorCode;
		this.errorFieldName = errorFieldName;
		this.errorDescription = errorDescription;
	}

	public ErrorDecorator(String errorCode, String errorDescription) {
		super();
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	private String errorCode;
	
	private String errorFieldName;
	
	private String errorDescription;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorFieldName() {
		return errorFieldName;
	}

	public void setErrorFieldName(String errorFieldName) {
		this.errorFieldName = errorFieldName;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
}
