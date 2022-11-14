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
