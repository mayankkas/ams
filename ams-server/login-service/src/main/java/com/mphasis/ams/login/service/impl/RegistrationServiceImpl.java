/**
 * 
 */
package com.mphasis.ams.login.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.ams.login.cassandra.EmployeeRepository;
import com.mphasis.ams.login.cassandra.entity.Employee;
import com.mphasis.ams.login.service.RegistrationService;

/**
 * @author Narendra.Bhati
 *
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	private EmployeeRepository empRepo;

	/* (non-Javadoc)
	 * @see com.mphasis.ams.login.service.RegistrationService#addEmployees(java.util.List)
	 */
	@Override
	public Integer addEmployees(List<Employee> employees) {		
		List<Employee> persistedEmployees = empRepo.saveAll(employees);
		// TODO Auto-generated method stub
		return persistedEmployees.size();
	}

	/* (non-Javadoc)
	 * @see com.mphasis.ams.login.service.RegistrationService#verifyEmployee(com.mphasis.ams.login.cassandra.entity.Employee)
	 */
	@Override
	public Boolean verifyEmployee(Employee employee) {
		
		Employee emp = this.empRepo.findById(employee.getEid()).orElse(null);
		
		if(null != emp && (emp.getEmailId().equalsIgnoreCase(employee.getEmailId()))) {
			String otp = UUID.randomUUID().toString();
			
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.mphasis.ams.login.service.RegistrationService#createPassword(com.mphasis.ams.login.cassandra.entity.Employee)
	 */
	@Override
	public Boolean createPassword(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
