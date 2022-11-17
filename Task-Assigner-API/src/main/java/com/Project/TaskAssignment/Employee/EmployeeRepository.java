package com.Project.TaskAssignment.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	@Query(value = "SELECT * FROM EMPLOYEE", nativeQuery = true)
	List<EmployeeEntity> TestFinder();

}
