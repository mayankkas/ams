package com.mphasis.ams.login.cassandra.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Employee {

	@PrimaryKey
	private int eid;

	private String emailId;

	private String role;
	
	private String projectCode;
	
	private String password;

	public Employee() {
	}

	/**
	 * Constructor to add a new employee by Admin.
	 * 
	 * @param eid
	 * @param emailId
	 * @param role
	 * @param projectCode
	 */
	public Employee(int eid, String emailId, String role, String projectCode) {
		this.eid = eid;
		this.emailId = emailId;
		this.role = role;
		this.projectCode = projectCode;
	}
	
	/**
	 * To create or change passwords by employee.
	 * 
	 * @param eid
	 * @param password
	 */
	public Employee(int eid, String password) {
		this.eid = eid;
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, emailId='%s', role='%s']", this.eid, this.emailId, this.role);
	}

	/**
	 * @return the eid
	 */
	public int getEid() {
		return eid;
	}

	/**
	 * @param eid the eid to set
	 */
	public void setEid(int eid) {
		this.eid = eid;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the projectCode
	 */
	public String getProjectCode() {
		return projectCode;
	}

	/**
	 * @param projectCode the projectCode to set
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

}
