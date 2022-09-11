package com.mindtree.Employee.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.Employee.VO.ResponseTemplate;
import com.mindtree.Employee.entity.Employee;
import com.mindtree.Employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService empService;

	@PostMapping
	public Employee add(@RequestBody Employee emp)
	{
	return empService.add(emp);
	}

	@GetMapping
	public List<Employee> listEmpp(){
	return empService.list();
	}

	@GetMapping("/{empId}")
	public ResponseTemplate empWithDept(@PathVariable long empId)
	{
	return empService.empWithDept(empId);
	}

	@PutMapping("/{empId}/{deptId}")
	public String updateDepartment(@PathVariable long empId,@PathVariable long deptId)
	{
	Employee emp = empService.assignDepartment(empId,deptId);
	if(emp!=null)
	{
	return emp.toString();
	}
	return "Sorry. Department or Employee Not Found";
	}

	@GetMapping("/employee-with-ascname/{dept_id}")
	public List<Employee> getByDeptId(@PathVariable long dept_id)
	{
	return empService.getByDeptId(dept_id);
	}

	@GetMapping("/employee-with-desc-age/{dept_id}")
	public List<Employee> getEmployeeByDepartmentWithDescAge(@PathVariable long dept_id)
	{
	return empService.getEmployeeByDepartmentWithDescAge(dept_id);
	}
}
