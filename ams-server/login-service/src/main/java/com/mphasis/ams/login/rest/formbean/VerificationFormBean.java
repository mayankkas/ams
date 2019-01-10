/**
 * 
 */
package com.mphasis.ams.login.rest.formbean;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * @author Narendra.Bhati
 *
 */
@DynamoDBTable(tableName="verificationCode")
public class VerificationFormBean {
	
	@DynamoDBAttribute(attributeName="employeeId")
	private String employeeId;
	
	@DynamoDBAttribute(attributeName="emailId")
	private String emailId;
	//storing code in database for verification of user and security purposes 
	//code kept as primary key because code will always be unique
	@DynamoDBHashKey
	private int code;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

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
