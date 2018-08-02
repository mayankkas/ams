package com.mphasis.ams.login.cassandra.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Employee {

	@PrimaryKey
	private int eid;
	
	private String emailId;
	
	private String password;
	
	private String role;

	public Employee() {
	}

	public Employee(int eid, String emailId, String role, String password) {
		this.eid = eid;
		this.emailId = emailId;
		this.role=role;
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, emailId='%s', role='%s']", 
				this.eid, this.emailId, this.role);
	}

}
