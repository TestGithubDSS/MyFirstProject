package com.mindtree.Department.service;

import com.mindtree.Department.entity.Department;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.Department.VO.RequestTemplate;
import com.mindtree.Department.entity.Department;

public interface DepartmentService {

	Department add(Department dept);
	List<Department> list();
	Department update(long id,String name);
	Department searchById(long id);
	List<RequestTemplate> listWithEmp();
	RequestTemplate specificDeptEmployee(long dept_id);
	}

