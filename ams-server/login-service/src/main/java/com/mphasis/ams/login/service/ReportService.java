package com.mphasis.ams.login.service;

import java.util.List;

import javax.sql.rowset.serial.SerialException;

import com.mphasis.ams.login.dynamo.entity.Employee;
import com.mphasis.ams.login.exception.ServiceException;
import com.mphasis.ams.login.rest.formbean.EmployeeHoursBean;

public interface ReportService {

	List<Employee> getReport(int projectId) throws ServiceException;
	List<EmployeeHoursBean> getReportMonthly(String month);
}
