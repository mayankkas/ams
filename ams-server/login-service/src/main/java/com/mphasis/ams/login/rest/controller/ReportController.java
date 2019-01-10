package com.mphasis.ams.login.rest.controller;

import java.util.List;

import com.mphasis.ams.login.dynamo.entity.Employee;
import com.mphasis.ams.login.rest.formbean.EmployeeHoursBean;

/**
 * @author Hamza.Khan
 *
 */
public interface ReportController {

	List<Employee> getReport(int projectId);

	List<EmployeeHoursBean> MonthlyReport(String month);

}
