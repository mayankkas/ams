package com.mphasis.ams.login.service.impl;

import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.mturk.model.ServiceException;
import com.mphasis.ams.login.dynamo.entity.Employee;
import com.mphasis.ams.login.repository.EmployeeHoursRepository;
import com.mphasis.ams.login.repository.EmployeeRepository;
import com.mphasis.ams.login.rest.controller.ReportController;
import com.mphasis.ams.login.rest.formbean.EmployeeHoursBean;
import com.mphasis.ams.login.service.ReportService;
/**
 * @author Hamza.Khan
 *
 */
@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	EmployeeRepository empRepo;
	EmployeeHoursRepository employeeHoursRepository;

	@Override
	public List<Employee> getReport(int projectCode) throws ServiceException {
		try {
			List<Employee>list=empRepo.findByProjectCode(projectCode);
			if(!list.isEmpty())
			{
				return list;
			}
		} catch (AmazonServiceException aws) {
			throw new ServiceException(aws.getErrorMessage());
		}
		return null;
	}

	@Override
	public List<EmployeeHoursBean> getReportMonthly(String month) {
		// TODO Auto-generated method stub
		try
		{
			List<EmployeeHoursBean> list=employeeHoursRepository.findByMonth(month);
			if(!list.isEmpty())
			{
				return list;
			}
			
		}catch(AmazonServiceException aws)
		{
			throw new ServiceException(aws.getErrorMessage());
		}
		return null;
	}

}
