/**
 * 
 */
package com.mphasis.ams.login.rest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindingResult;

import com.mphasis.ams.login.rest.formbean.AddEmployeesFormBean;
import com.mphasis.ams.login.rest.formbean.PasswordFormBean;
import com.mphasis.ams.login.rest.formbean.VerificationFormBean;
import com.mphasis.ams.login.rest.response.BaseResponse;

/**
 * @author Narendra.Bhati
 *
 */
public interface RegistrationController {

	BaseResponse addEmployees(AddEmployeesFormBean formBean, BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response);
	
	String verifyEmployee(VerificationFormBean formBean, BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException;
	
	BaseResponse createPassword(PasswordFormBean formBean, BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response);
	
}
