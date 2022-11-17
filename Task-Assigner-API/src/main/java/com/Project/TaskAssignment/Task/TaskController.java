package com.Project.TaskAssignment.Task;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TaskController {

	@Autowired
	private TaskServices taskServices;

	@PostMapping(path = "/tasks", consumes = "application/json", produces = "application/json")
	public ResponseEntity<TaskEntity> addTask(@Valid @RequestBody TaskEntity informationEntity) {

		return new ResponseEntity<TaskEntity>(taskServices.PostTask(informationEntity), HttpStatus.OK);
	}

	@PatchMapping(path = "/tasks/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<TaskEntity> updateTask(@RequestBody TaskEntity informmationEntity, @PathVariable Long id) {
		return new ResponseEntity<TaskEntity>(taskServices.UpdateTask(id, informmationEntity), HttpStatus.OK);
	}

	@GetMapping(path = "/tasks")
	public ResponseEntity<List<TaskEntity>> getAllTasksFiltered(@RequestParam(required = false) Boolean assigned) {
		if (assigned != null)
			return new ResponseEntity<List<TaskEntity>>(taskServices.GetAllTasksFiltered(assigned), HttpStatus.OK);
		return new ResponseEntity<List<TaskEntity>>(taskServices.GetAllTasks(), HttpStatus.OK);
	}

	@GetMapping(path = "/tasks/{id}")
	public ResponseEntity<TaskEntity> getTask(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<TaskEntity>(taskServices.getTaskEntityById(id), HttpStatus.OK);
	}
}