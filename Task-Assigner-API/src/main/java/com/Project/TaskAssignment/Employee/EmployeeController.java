package com.Project.TaskAssignment.Employee;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeServices employeeServices;

	@PostMapping("/employee")
	public ResponseEntity<EmployeeEntity> createEmployee(@Valid @RequestBody EmployeeEntity employeeEntity) {
		return new ResponseEntity<EmployeeEntity>(employeeServices.CreateEmployee(employeeEntity), HttpStatus.OK);
	}

	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeEntity>> getEmployees() {
		return new ResponseEntity<List<EmployeeEntity>>(employeeServices.GetAllEmployees(), HttpStatus.OK);
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<EmployeeEntity>(employeeServices.GetEmployeeById(id), HttpStatus.OK);
	}

	@GetMapping("/employee/available")
	public ResponseEntity<List<EmployeeEntity>> getAvailableEmployees(@RequestParam(required = true) Long jobId) {
		return new ResponseEntity<List<EmployeeEntity>>(employeeServices.GetAllEmployeesAvailable(jobId),
				HttpStatus.OK);
	}
}

//GET /temps?jobId={jobId} - List temps that are available for a job based on the jobs date range
// findByStartDateBetween

