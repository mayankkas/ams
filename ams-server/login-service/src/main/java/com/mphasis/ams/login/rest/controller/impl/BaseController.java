package com.mphasis.ams.login.rest.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.mphasis.ams.login.rest.response.ErrorDecorator;
import com.mphasis.ams.login.rest.response.ErrorResponse;
/**
 * @author Hamza.Khan
 *
 */
@Component
public class BaseController {

	protected ErrorResponse buildValidationErrorResponse(BindingResult bindingResult, HttpServletResponse response) {
		List<ErrorDecorator> list = new ArrayList();
		bindingResult.getFieldErrors()
				.forEach(error -> list.add(new ErrorDecorator(error.getField(), error.getDefaultMessage())));
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

		return new ErrorResponse(list);
	}

}
