package com.Project.TaskAssignment.Employee;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeServices {
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<EmployeeEntity> GetAllEmployees() {
		return employeeRepository.findAll();
	}

	public EmployeeEntity CreateEmployee(EmployeeEntity employeeEntity) {
		return employeeRepository.save(employeeEntity);
	}

	public EmployeeEntity GetEmployeeById(Long Id) {
		Optional<EmployeeEntity> employee = employeeRepository.findById(Id);
		if (employee.isEmpty())
			throw new Error("Employee not found");
		return employee.get();
	}
}