package com.mphasis.ams.login.rest.response;

import java.util.List;
/**
 * @author Hamza.Khan
 *
 */
public class ErrorResponse {

	public ErrorResponse(List<ErrorDecorator> errors) {
		super();
		this.errors = errors;
	}

	private List<ErrorDecorator> errors;

	public List<ErrorDecorator> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorDecorator> errors) {
		this.errors = errors;
	}
}
