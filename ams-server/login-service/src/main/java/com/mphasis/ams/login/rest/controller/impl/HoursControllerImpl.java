package com.mphasis.ams.login.rest.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.http.HttpResponse;
import com.mphasis.ams.login.exception.BusinessException;
import com.mphasis.ams.login.rest.controller.HoursController;
import com.mphasis.ams.login.rest.formbean.EmployeeHoursBean;
import com.mphasis.ams.login.rest.response.ErrorDecorator;
import com.mphasis.ams.login.rest.response.ErrorResponse;
import com.mphasis.ams.login.service.impl.HoursServiceImpl;
/**
 * @author Hamza.Khan
 *
 */
@RestController
public class HoursControllerImpl implements HoursController {

	@Autowired
	HoursServiceImpl hourServiceImpl;
	@Autowired
	BaseController baseController;

	// add billed hours of employee
	@Override
	@PostMapping("/hours/addhours")
	public ResponseEntity<EmployeeHoursBean> addHours(@RequestBody EmployeeHoursBean homeFormBean,
			BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {

		if (bindingResult.hasErrors()) {

			baseController.buildValidationErrorResponse(bindingResult, response);
		}
		hourServiceImpl.addHours(homeFormBean, request, response);
		return new ResponseEntity<EmployeeHoursBean>(homeFormBean, HttpStatus.OK);
	}

	//Get total billed hours auto-populated negating weekends and public holidays
	@Override
	@GetMapping("/hours/getTotalHours")

	public int getTotalHours() {
		return hourServiceImpl.calculateTotalHours(0, 0, 0);
	}

	//update hours of employee
	@Override
	@PostMapping("/hours/update")
	public ResponseEntity<EmployeeHoursBean> updateHours(EmployeeHoursBean hours, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if (bindingResult.hasErrors()) {
			baseController.buildValidationErrorResponse(bindingResult, response);
		}
		hourServiceImpl.addHours(hours, request, response);
		return new ResponseEntity<EmployeeHoursBean>(hours, HttpStatus.OK);
	}

	/*
	 * @Override
	 * 
	 * @GetMapping("/hour/{month}") public List<EmployeeHoursBean>
	 * MonthlyHours(@PathVariable String month,HttpServletRequest request,
	 * HttpServletResponse response) {
	 * 
	 * return hourServiceImpl.getMonthlyHours(month, request, response);
	 * 
	 * }
	 */

}
