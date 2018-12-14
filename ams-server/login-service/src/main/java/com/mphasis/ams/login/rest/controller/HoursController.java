package com.mphasis.ams.login.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import com.mphasis.ams.login.rest.formbean.EmployeeHoursBean;

public interface HoursController {

	ResponseEntity<EmployeeHoursBean> addHours(@RequestBody EmployeeHoursBean homeFormBean,BindingResult bindingResult,HttpServletRequest request, HttpServletResponse response);
	int getTotalHours();
	//List<EmployeeHoursBean> MonthlyHours(String month,HttpServletRequest request, HttpServletResponse response);
	
}
