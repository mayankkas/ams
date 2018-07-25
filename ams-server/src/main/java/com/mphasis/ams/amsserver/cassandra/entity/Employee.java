package com.mphasis.ams.amsserver.cassandra.entity;

import java.math.BigInteger;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Employee {

	@PrimaryKey
	private BigInteger eid;

	private String firstName;

	private String lastName;
	
	private String emailId;
	
	private String password;

	public Employee() {
	}

	public Employee(BigInteger eid, String firstName, String lastName, String emailId, String password) {
		this.eid = eid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s', emailId='%s']", this.eid,
				this.firstName, this.lastName, this.emailId);
	}

}
