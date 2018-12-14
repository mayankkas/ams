package com.mphasis.ams.login.dynamo.entity;

import java.util.List;

public class EmployeeWrapper {
	
	private List<Employee> employees;

	/**
	 * @return the employees
	 */
	public List<Employee> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
