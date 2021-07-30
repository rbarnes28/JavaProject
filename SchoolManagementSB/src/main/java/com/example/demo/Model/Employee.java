package com.example.demo.Model;

import java.sql.Date;

public class Employee extends Person {
	
	public long getEmpID() {
		return empID;
	}
	public void setEmpID(long empID) {
		this.empID = empID;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	private long empID;
    private String department;
    private long salary;
    private String designation;
}
