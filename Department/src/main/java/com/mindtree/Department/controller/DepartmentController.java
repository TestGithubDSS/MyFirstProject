package com.mindtree.Department.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.Department.VO.RequestTemplate;
import com.mindtree.Department.entity.Department;
import com.mindtree.Department.service.DepartmentService;


@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	DepartmentService deptService;

	@PostMapping
	public Department add(@RequestBody Department dept)
	{
	return deptService.add(dept);
	}

	@GetMapping
	public List<Department> list()
	{
	return deptService.list();
	}

	@GetMapping("/{id}")
	public Department searchById(@PathVariable long id)
	{
	return deptService.searchById(id);
	}

	@GetMapping("/all-department-employee")
	public List<RequestTemplate> listWithEmp()
	{
	return deptService.listWithEmp();
	}

	@GetMapping("/department-with-employee/{dept_id}")
	public RequestTemplate specificDeptEmp(@PathVariable long dept_id)
	{
	return deptService.specificDeptEmployee(dept_id);
	}


}
