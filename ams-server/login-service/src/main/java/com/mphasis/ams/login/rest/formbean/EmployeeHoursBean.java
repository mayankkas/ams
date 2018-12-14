package com.mphasis.ams.login.rest.formbean;



import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName = "Hours")
public class EmployeeHoursBean {

	private String id;
	private int employeeId;
	private int totalBilledHours;
	private double overTimeHours;
	private double leaves;
	private String furlough;
	private int furloughDays;
	private String month;
	
	
	public EmployeeHoursBean(){}

	@DynamoDBAttribute(attributeName="Month")
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	
	@DynamoDBAutoGeneratedKey
	@DynamoDBHashKey(attributeName="Id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBAttribute(attributeName="employeeId")
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@DynamoDBAttribute(attributeName="TotalBilledHours")
	public int getTotalBilledHours() {
		return totalBilledHours;
	}

	public void setTotalBilledHours(int totalBilledHours) {
		this.totalBilledHours = totalBilledHours;
	}

	@DynamoDBAttribute(attributeName="OverTime")
	public double getOverTimeHours() {
		return overTimeHours;
	}

	public void setOverTimeHours(double overTimeHours) {
		this.overTimeHours = overTimeHours;
	}

	@DynamoDBAttribute(attributeName="leaves")
	public double getLeaves() {
		return leaves;
	}

	public void setLeaves(double leaves) {
		this.leaves = leaves;
	}

	@DynamoDBAttribute(attributeName="furlough")
	public String getFurlough() {
		return furlough;
	}

	public void setFurlough(String furlough) {
		this.furlough = furlough;
	}

	@DynamoDBAttribute(attributeName="furloughDays")
	public int getFurloughDays() {
		return furloughDays;
	}

	public void setFurloughDays(int furloughDays) {
		this.furloughDays = furloughDays;
	}

	@Override
	public String toString() {
		return "EmployeeHoursBean [id=" + id + ", employeeId=" + employeeId + ", totalBilledHours=" + totalBilledHours
				+ ", overTimeHours=" + overTimeHours + ", leaves=" + leaves + ", furlough=" + furlough
				+ ", furloughDays=" + furloughDays + ", month=" + month + "]";
	}

	


	

	

}