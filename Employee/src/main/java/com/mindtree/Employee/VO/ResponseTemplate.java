package com.mindtree.Employee.VO;

import com.mindtree.Employee.entity.Employee;

public class ResponseTemplate {
	private Employee employee;
	private Department department;
	public Employee getEmployee() {
	return employee;
	}
	public void setEmployee(Employee employee) {
	this.employee = employee;
	}
	public Department getDepartment() {
	return department;
	}
	public void setDepartment(Department department) {
	this.department = department;
	}
	public ResponseTemplate(Employee employee, Department department) {
	super();
	this.employee = employee;
	this.department = department;
	}
	public ResponseTemplate() {
	super();
	// TODO Auto-generated constructor stub
	}

	}
