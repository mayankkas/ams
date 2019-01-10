package com.mphasis.ams.login.rest.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.ams.login.dynamo.entity.Employee;
import com.mphasis.ams.login.rest.controller.ReportController;
import com.mphasis.ams.login.rest.formbean.EmployeeHoursBean;
import com.mphasis.ams.login.service.ReportService;
import com.mphasis.ams.login.service.impl.ReportServiceImpl;
/**
 * @author Hamza.Khan
 *
 */
@RestController
public class ReportControllerImpl implements ReportController {

	@Autowired
	ReportServiceImpl reportServiceImpl;
	
	//get reports according to project id entered by user
	@Override
	@GetMapping("/report/{projectCode}")
	public List<Employee> getReport(@PathVariable int projectCode) {
		List<Employee> list=reportServiceImpl.getReport(projectCode);
		return list;
	}

	//get reports according to the month entered by user
	@Override
	@GetMapping("/MonthlyReports/{month}")
	public List<EmployeeHoursBean> MonthlyReport(@PathVariable String month) {
		List<EmployeeHoursBean> list=reportServiceImpl.getReportMonthly(month);
		return list;
	}
	

}
