package com.Project.TaskAssignment.Employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.Project.TaskAssignment.Task.TaskEntity;

@Entity
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Number id;
	private String firstName;
	private String lastName;
	private TaskEntity[] tasks;

	public Number getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public TaskEntity[] getTasks() {
		return tasks;
	}

	public void setTasks(TaskEntity[] tasks) {
		this.tasks = tasks;
	}
}
