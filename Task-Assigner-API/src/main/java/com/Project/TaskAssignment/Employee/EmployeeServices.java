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

		/* What to do, cant do it purely with mysql
		 * Will need to get all tasks, of each employee, check all who are compatible, get their tasks
		 * return an array of all who pass
		 * This doesnt need to access tasks service as you can just get the tasks from the employee*/

		// GET /temps?jobId={jobId} - List temps that are available for a job based on
		// the jobs date range
	}
}