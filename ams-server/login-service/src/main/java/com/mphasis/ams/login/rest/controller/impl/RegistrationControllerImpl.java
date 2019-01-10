/**
 * 
 */
package com.mphasis.ams.login.rest.controller.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import com.mphasis.ams.login.dynamo.entity.Employee;
import com.mphasis.ams.login.dynamo.entity.EmployeeWrapper;
import com.mphasis.ams.login.email.SendEmail;
import com.mphasis.ams.login.repository.EmployeeRepository;
import com.mphasis.ams.login.repository.VerificationCodeRepository;
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
	
	@Autowired
	private VerificationCodeRepository verificationRepository;
	
	@Autowired
	private SendEmail sendEmail;
	

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
	//sending email with code to user for verification
	//retrieving code that was generated and was sent to user 
	//storing code in database for matching the code the user will further enter for verification 
	@Override
	@PostMapping("/verification")
	public String verifyEmployee(VerificationFormBean formBean, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			sendEmail.setTo(formBean.getEmailId());
			System.out.println(sendEmail.getTo());
			sendEmail.sendMail();
			formBean.setCode(sendEmail.getCode());
			verificationRepository.save(formBean);
		return "Message sent successfully";
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
