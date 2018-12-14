package com.mphasis.ams.attendance.cassandra.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class WorkHoursFormBean {

	@PrimaryKey
	private int id;
	private Employee employee;
	private int totalBilledHours;
	private int overTimeHours;
	private int leaves;
	Boolean furloughLeaves;
	
	WorkHoursFormBean(){}

	@Override
	public String toString() {
		return "UpdateProfile [id=" + id + ", employee=" + employee + ", totalBilledHours=" + totalBilledHours
				+ ", overTimeHours=" + overTimeHours + ", leaves=" + leaves + ", furloughLeaves=" + furloughLeaves
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getTotalBilledHours() {
		return totalBilledHours;
	}

	public void setTotalBilledHours(int totalBilledHours) {
		this.totalBilledHours = totalBilledHours;
	}

	public int getOverTimeHours() {
		return overTimeHours;
	}

	public void setOverTimeHours(int overTimeHours) {
		this.overTimeHours = overTimeHours;
	}

	public int getLeaves() {
		return leaves;
	}

	public void setLeaves(int leaves) {
		this.leaves = leaves;
	}

	public Boolean getFurloughLeaves() {
		return furloughLeaves;
	}

	public void setFurloughLeaves(Boolean furloughLeaves) {
		this.furloughLeaves = furloughLeaves;
	}

	public WorkHoursFormBean(int id, Employee employee, int totalBilledHours, int overTimeHours, int leaves,
			Boolean furloughLeaves) {
		super();
		this.id = id;
		this.employee = employee;
		this.totalBilledHours = totalBilledHours;
		this.overTimeHours = overTimeHours;
		this.leaves = leaves;
		this.furloughLeaves = furloughLeaves;
	}
	
	
	
}
