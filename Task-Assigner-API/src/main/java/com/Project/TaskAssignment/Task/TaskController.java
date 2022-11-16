package com.Project.TaskAssignment.Task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TaskController {

	@Autowired
	private TaskServices taskServices;

	@PostMapping(path = "/tasks", consumes = "application/json", produces = "application/json")
	public ResponseEntity<TaskEntity> addTask(@RequestBody TaskEntity informationEntity) {

		return new ResponseEntity<TaskEntity>(taskServices.PostTask(informationEntity), HttpStatus.OK);
	}

	@GetMapping(path = "/tasks")
	public ResponseEntity<List<TaskEntity>> getAllTasks() {
		return new ResponseEntity<List<TaskEntity>>(taskServices.GetAllTasks(), HttpStatus.OK);
	}
}

// POST /jobs - Creates a job 
// PATCH /jobs/{id} - Updates job, endpoint should be used to assign temps to jobs 
// GET /jobs - Fetch all jobs 
// GET /jobs?assigned={true|false} - Filter by whether a job is assigned to a temp  or not 
// GET /jobs/{id} - (id, name, tempId, startDate, endDate)
// GET /jobs/{id}