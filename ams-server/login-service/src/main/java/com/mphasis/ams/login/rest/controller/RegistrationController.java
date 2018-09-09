/**
 * 
 */
package com.mphasis.ams.login.rest.controller;

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
	
	BaseResponse verifyEmployee(VerificationFormBean formBean, BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response);
	
	BaseResponse createPassword(PasswordFormBean formBean, BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response);
}
