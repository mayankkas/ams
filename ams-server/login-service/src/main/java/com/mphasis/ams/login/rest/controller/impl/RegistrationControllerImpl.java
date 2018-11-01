/**
 * 
 */
package com.mphasis.ams.login.rest.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mphasis.ams.login.cassandra.EmployeeRepository;
import com.mphasis.ams.login.cassandra.entity.Employee;
import com.mphasis.ams.login.cassandra.entity.EmployeeWrapper;
import com.mphasis.ams.login.rest.controller.RegistrationController;
import com.mphasis.ams.login.rest.formbean.AddEmployeesFormBean;
import com.mphasis.ams.login.rest.formbean.PasswordFormBean;
import com.mphasis.ams.login.rest.formbean.VerificationFormBean;
import com.mphasis.ams.login.rest.response.BaseResponse;
import com.mphasis.ams.login.service.RegistrationService;

/**
 * @author Narendra.Bhati
 *
 */
@RestController
public class RegistrationControllerImpl implements RegistrationController 
{
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	/* (non-Javadoc)
	 * @see com.mphasis.ams.login.rest.controller.RegistrationController#addEmployees(com.mphasis.ams.login.rest.formbean.AddEmployeesFormBean, org.springframework.validation.BindingResult, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	@PostMapping("/employees")
	public BaseResponse addEmployees(AddEmployeesFormBean formBean, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	
		return null;
	}
	
	@PostMapping("/employee/register")
	public ResponseEntity<Employee> registerEmployee(@RequestBody Employee registerEmployee) {
		
		System.out.println("Create Customer: " + registerEmployee.getFirstName() + "..."); 
		
		Employee employee = employeeRepository.save(registerEmployee);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@PostMapping("/admin/addemployees")
	public List<Employee>  addEmployees(@RequestBody EmployeeWrapper employeeWrapper)
	{
			List<Employee> response = new ArrayList<Employee>();
		
		for (Employee employee: employeeWrapper.getEmployees()){
			
			System.out.println("Create Customer: " + employee.getFirstName() + "...");
			
			Employee saveEmployee = employeeRepository.save(employee);
			
			response.add(saveEmployee);
	    }
		
		return response;
	}
	

	/* (non-Javadoc)
	 * @see com.mphasis.ams.login.rest.controller.RegistrationController#verifyEmployee(com.mphasis.ams.login.rest.formbean.VerificationFormBean, org.springframework.validation.BindingResult, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	@PostMapping("/verification")
	public BaseResponse verifyEmployee(VerificationFormBean formBean, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.mphasis.ams.login.rest.controller.RegistrationController#createPassword(com.mphasis.ams.login.rest.formbean.PasswordFormBean, org.springframework.validation.BindingResult, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	@PostMapping("/credentials")
	public BaseResponse createPassword(PasswordFormBean formBean, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
