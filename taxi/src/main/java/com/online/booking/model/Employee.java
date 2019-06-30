package com.online.booking.model;

import java.util.Date;

public class Employee {
	
	private String name;
	private int empId;
	private String dept;
	private Date joiningDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [name=");
		builder.append(name);
		builder.append(", empId=");
		builder.append(empId);
		builder.append(", dept=");
		builder.append(dept);
		builder.append(", joiningDate=");
		builder.append(joiningDate);
		builder.append("]");
		return builder.toString();
	}

}
