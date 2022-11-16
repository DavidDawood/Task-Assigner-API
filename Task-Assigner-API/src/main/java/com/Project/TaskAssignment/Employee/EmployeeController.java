package com.Project.TaskAssignment.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {


	@GetMapping("/test")
	public String TestFunction() {
		return "This is a test";
	}
}


// POST /temps - Create a temp
// GET /temps - List all temps
// GET /temps?jobId={jobId} - List temps that are available for a job based on the jobs date range
// GET /temps/{id} - get temp by id (should also display jobs they’ve been assigned to) ## Example Payloads
// GET /temps/{id}