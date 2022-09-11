package com.mindtree.Department.implementation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.Department.VO.Employee;
import com.mindtree.Department.VO.RequestTemplate;
import com.mindtree.Department.entity.Department;
import com.mindtree.Department.repository.DepartmentRepository;
import com.mindtree.Department.service.DepartmentService;

@Component
public class DepartmentImpl implements DepartmentService {

@Autowired
DepartmentRepository deptRepo;
@Autowired
RestTemplate restTemplate;

@Override
public Department add(Department dept) {
return deptRepo.save(dept);
}

@Override
public List<Department> list() {
return deptRepo.findAll();
}

@Override
public Department update(long id, String name) {
Department dept = deptRepo.findById(id);
dept.setName(name);
return deptRepo.save(dept);
}

@Override
public Department searchById(long id) {
if(deptRepo.findById(id)==null)
{
return null;
}
return deptRepo.findById(id);
}

@Override
public List<RequestTemplate> listWithEmp() {
List<RequestTemplate> fullList = new ArrayList<RequestTemplate>();
List<Department> allDept = this.list();
Iterator<Department> ir = allDept.iterator();
while(ir.hasNext())
{
Department dpt = ir.next();
ResponseEntity<Employee[]> response =
 restTemplate.getForEntity(
 "http://EMPLOYEE-SERVICE/employee/employee-with-ascname/"+dpt.getId(),
 Employee[].class);
Employee[] employees = response.getBody();
List<Employee> emps = Arrays.asList(employees);
  RequestTemplate RTm = new RequestTemplate();
RTm.setDepartment(dpt);
RTm.setEmployeeList(emps);
fullList.add(RTm);
}
return fullList;
}

@Override
public RequestTemplate specificDeptEmployee(long dept_id) {
Department department  = this.searchById(dept_id);

ResponseEntity<Employee[]> response =
 restTemplate.getForEntity(
 "http://EMPLOYEE-SERVICE/employee/employee-with-desc-age/"+department.getId(),
 Employee[].class);
Employee[] employee = response.getBody();
List<Employee> employees = Arrays.asList(employee);
RequestTemplate requestTemplate = new RequestTemplate();

requestTemplate.setDepartment(department);
requestTemplate.setEmployeeList(employees);

return requestTemplate;
}

}



