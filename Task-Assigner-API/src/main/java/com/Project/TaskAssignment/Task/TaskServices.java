package com.Project.TaskAssignment.Task;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.TaskAssignment.Employee.EmployeeEntity;
import com.Project.TaskAssignment.Employee.EmployeeServices;

@Service
@Transactional
public class TaskServices {

	@Autowired
	private EmployeeServices employeeServices;

	@Autowired
	public TaskRepository taskRepository;

	public List<TaskEntity> GetAllTasks() {
		return taskRepository.findAll();
	}

	public TaskEntity getTaskEntityById(Long id) {

		final Optional<TaskEntity> foundTask = taskRepository.findById(id);

		if (foundTask.isEmpty())
			throw new Error("Task not found");
		return foundTask.get();
	}

	public List<TaskEntity> GetAllTasksFiltered(Boolean check) {
		return check ? taskRepository.findByAssignedEmployeeIsNotNull() : taskRepository.findByAssignedEmployeeIsNull();

	}

	public TaskEntity PostTask(TaskEntity taskEntity) {
		return taskRepository.save(taskEntity);
	}

	public TaskEntity UpdateTask(Long id, TaskEntity taskEntity, Long employeeId) {

		Optional<TaskEntity> foundTask = taskRepository.findById(id);

		if (foundTask.isEmpty())
			throw new Error("Task not found");
		if (employeeId != null) {
			final EmployeeEntity employee = employeeServices.GetEmployeeById(employeeId);
			foundTask.get().setAssignedEmployee(employee);
		}

		foundTask.get().setName(taskEntity.getName());
		foundTask.get().setDescription(taskEntity.getDescription());
		foundTask.get().setStartDate(taskEntity.getStartDate());
		foundTask.get().setEndDate(taskEntity.getEndDate());

		return taskRepository.save(foundTask.get());
	}
}
