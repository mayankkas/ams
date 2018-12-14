package com.mphasis.ams.login.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import com.mphasis.ams.login.rest.formbean.EmployeeHoursBean;

public interface HoursService {

	int calculateTotalHours(double overtime, double leaves, int forloughdays);

	Boolean addHours(EmployeeHoursBean workHoursFormBean,HttpServletRequest request, HttpServletResponse response);
	List<EmployeeHoursBean> getMonthlyHours(String month,HttpServletRequest request, HttpServletResponse response);

}
