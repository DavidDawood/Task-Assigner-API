package com.Project.TaskAssignment.Task;

import java.util.List;
import java.util.Optional;

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

	public TaskEntity UpdateTask(Long id, TaskEntity taskEntity) {

		Optional<TaskEntity> foundTask = taskRepository.findById(id);

		if (foundTask.isEmpty())
			throw new Error("Task not found");
		foundTask.get().setAssignedEmployee(taskEntity.getAssignedEmployee());
		foundTask.get().setName(taskEntity.getName());
		foundTask.get().setDescription(taskEntity.getDescription());
		foundTask.get().setStartDate(taskEntity.getStartDate());
		foundTask.get().setEndDate(taskEntity.getEndDate());
		
		System.out.println(foundTask.get().getName());
		return taskRepository.save(foundTask.get());
	}
}
