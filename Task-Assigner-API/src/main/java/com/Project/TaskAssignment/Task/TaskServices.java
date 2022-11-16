package com.Project.TaskAssignment.Task;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TaskServices {

	@Autowired
	public TaskRepository taskRepository;

	public List<TaskEntity> GetAllTasks() {
		return taskRepository.findAll();
	}

	public TaskEntity PostTask(TaskEntity taskEntity) {

		return taskRepository.save(taskEntity);
	}
}
