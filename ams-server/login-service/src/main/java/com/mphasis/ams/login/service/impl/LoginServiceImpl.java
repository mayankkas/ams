package com.mphasis.ams.login.service.impl;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.mturk.model.ServiceException;
import com.mphasis.ams.login.dynamo.entity.Employee;
import com.mphasis.ams.login.exception.BusinessException;
import com.mphasis.ams.login.repository.EmployeeRepository;
import com.mphasis.ams.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee login(int employeeId, String password, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		try
		{
		if (employeeRepository.findByEid(employeeId) != null) {

			if (employeeRepository.findByPassword(password) != null) {

				return employeeRepository.findByEid(employeeId);
			}
		}
		}
		catch(AmazonServiceException a)
		{
			throw new ServiceException(a.getErrorMessage());
		}

		return null;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}

	public Employee addEmployee(int eid, String emailId, String role, String password) {

		if (this.employeeRepository.findById(eid).orElse(null) == null) {
			Employee emp = new Employee(eid, emailId, role, password);
			return this.employeeRepository.save(emp);
		}
		return null;
	}

	public void deleteEmployee(int eid) {

		Employee emp = this.employeeRepository.findById(eid).orElse(null);
		System.out.println(emp);
		if (emp != null)
			this.employeeRepository.delete(emp);
		System.out.println(this.employeeRepository.findById(eid).orElse(null));
	}

	public String listEmployee() {
		System.out.println("testEmployee");
		StringBuilder b = new StringBuilder();
		this.employeeRepository.findAll().forEach(employee -> {
			b.append(employee.toString() + "\n");
		});
		return b.toString();
	}

}
