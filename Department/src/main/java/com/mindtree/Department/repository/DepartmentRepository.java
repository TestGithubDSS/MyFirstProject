package com.mindtree.Department.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.Department.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

Department findById(long id);

// @Query(value="SELECT e.* FROM employee e WHERE e.dept_id=:id ", nativeQuery = true)
// List<Employee> empByDept(@Param("id") long id);
}

