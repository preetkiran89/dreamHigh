package com.practice.Model;

public class Employee {

	private String name;
	private int id;
	private Enum degreeStatus;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Enum getDegreeStatus() {
		return degreeStatus;
	}

	public void setDegreeStatus(Enum degreeStatus) {
		this.degreeStatus = degreeStatus;
	}
	
}

enum Degree {
	GIVEN,NOTGIVEN;
}