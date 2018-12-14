package com.mphasis.ams.login.rest.controller.impl;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mphasis.ams.login.exception.BusinessException;
import com.mphasis.ams.login.exception.ExceptionResponse;
import com.mphasis.ams.login.exception.ServiceException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ExceptionResponse> BusinessException(BusinessException e) throws BusinessException {
		System.out.println("hi in bs Exception");
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setCode(org.springframework.http.HttpStatus.BAD_REQUEST.value());
		exceptionResponse.setMessage(e.getMessage());
		System.out.println(e);
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,
				org.springframework.http.HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ExceptionResponse> serviceExceptionhandler(ServiceException e) throws ServiceException {
		System.out.println("hi in serv Exception");
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setCode(org.springframework.http.HttpStatus.BAD_REQUEST.value());
		exceptionResponse.setMessage(e.getMessage());
		System.out.println(e);
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,
				org.springframework.http.HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ExceptionResponse> AllException(Throwable e) throws Throwable {
		System.out.println("hi in throwable Exception");
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setCode(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value());
		exceptionResponse.setMessage(e.getMessage());
		System.out.println(e);
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,
				org.springframework.http.HttpStatus.BAD_REQUEST);
	}

}
