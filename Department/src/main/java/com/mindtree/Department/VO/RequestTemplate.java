package com.mindtree.Department.VO;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.Department.entity.Department;


public class RequestTemplate {
	private Department department;
	private List<Employee> employeeList = new ArrayList<Employee>();


	public RequestTemplate(Department department, List<Employee> employeeList) {
	super();
	this.department = department;
	this.employeeList = employeeList;
	}


	public Department getDepartment() {
	return department;
	}


	public void setDepartment(Department department) {
	this.department = department;
	}


	public List<Employee> getEmployeeList() {
	return employeeList;
	}


	public void setEmployeeList(List<Employee> employeeList) {
	this.employeeList = employeeList;
	}


	public RequestTemplate() {
	super();
	// TODO Auto-generated constructor stub
	}


	}
