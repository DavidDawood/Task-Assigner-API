package com.Project.TaskAssignment.Employee;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.TaskAssignment.Task.TaskEntity;
import com.Project.TaskAssignment.Task.TaskServices;

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

	public List<EmployeeEntity> GetAllEmployeesAvailable(Long taskId) {

		final List<EmployeeEntity> allTasks = employeeRepository.TestFinder();

		return allTasks;
		
		// figure out on employeeRepository how to check relationships in mysql and search that way via its query

		// so inside of every employee, check all their current tasks,
		// - If the task is between the start date and end date of the task im checking,
		// stop it and break
		// - if no tasks are returned, it means we can do it, if there is even one, it
		// means we cant
		// - its must be OR, so if its start date is after the select tasks date OR its
		// end dates

		// GET /temps?jobId={jobId} - List temps that are available for a job based on
		// the jobs date range
	}
}