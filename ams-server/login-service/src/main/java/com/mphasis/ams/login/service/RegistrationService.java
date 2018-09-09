package com.mphasis.ams.login.service;

import java.util.List;

import com.mphasis.ams.login.cassandra.entity.Employee;

public interface RegistrationService {

	Integer addEmployees(List<Employee> employees);

	Boolean verifyEmployee(Employee employee);

	Boolean createPassword(Employee employee);

}
