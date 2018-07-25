package com.mphasis.ams.amsserver.rest.request;

import java.math.BigInteger;


public class AmsUser {

	private BigInteger eid;

	private String firstName;

	private String lastName;
	
	private String emailId;
	
	private String password;

	public BigInteger getEid() {
		return eid;
	}

	public void setEid(BigInteger eid) {
		this.eid = eid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
