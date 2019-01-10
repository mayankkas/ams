package com.mphasis.ams.login.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.mphasis.ams.login.dynamo.entity.Employee;
import com.mphasis.ams.login.exception.BusinessException;
import com.sun.mail.iap.Response;
/**
 * @author Hamza.Khan
 *
 */
public interface LoginController {

	public ResponseEntity<Employee> login(int employeeId,String password,HttpServletRequest request, HttpServletResponse response);
	public String logout(HttpServletRequest request, HttpServletResponse response);
}
