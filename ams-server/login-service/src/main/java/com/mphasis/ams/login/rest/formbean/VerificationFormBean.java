/**
 * 
 */
package com.mphasis.ams.login.rest.formbean;

/**
 * @author Narendra.Bhati
 *
 */
public class VerificationFormBean {
	
	private String employeeId;
	
	private String emailId;

	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
}
