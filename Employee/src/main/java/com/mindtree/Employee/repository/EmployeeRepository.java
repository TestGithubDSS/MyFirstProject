package com.mindtree.Employee.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.Employee.entity.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

Employee findById(long id);

@Query(value="SELECT * FROM employee WHERE dept_id=:dept_id ORDER BY name ASC", nativeQuery = true)
List<Employee> getByDeptId(@Param("dept_id") long dept_id);

@Query(value="SELECT * FROM employee WHERE dept_id=:dept_id ORDER BY age DESC", nativeQuery = true)
List<Employee> getEmployeeByDepartmentWithDescAge(@Param("dept_id") long dept_id);
}


