package com.mphasis.ams.login.rest.controller.impl;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mphasis.ams.login.exception.BusinessException;
import com.mphasis.ams.login.exception.ExceptionResponse;
import com.mphasis.ams.login.exception.ServiceException;
/**
 * @author Hamza.Khan
 *
 */
@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ExceptionResponse> BusinessException(BusinessException e) throws BusinessException {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setCode(e.getCode());
		exceptionResponse.setMessage(e.getMessage());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,
				org.springframework.http.HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ExceptionResponse> serviceExceptionhandler(ServiceException e) throws ServiceException {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setCode(org.springframework.http.HttpStatus.BAD_REQUEST.value());
		exceptionResponse.setMessage(e.getMessage());
		System.out.println(e);
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,
				org.springframework.http.HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ExceptionResponse> AllException(Throwable e) throws Throwable {
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setCode(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value());
		exceptionResponse.setMessage(e.getMessage());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,
				org.springframework.http.HttpStatus.BAD_REQUEST);
	}

}
