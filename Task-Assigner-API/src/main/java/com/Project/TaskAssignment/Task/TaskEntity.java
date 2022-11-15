package com.Project.TaskAssignment.Task;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.Project.TaskAssignment.Employee.EmployeeEntity;

@Entity
public class TaskEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Date startDate;
	private Date endDate;
	private String name;
	private String description;
	private EmployeeEntity assignedEmployee;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeEntity getAssignedEmployee() {
		return assignedEmployee;
	}

	@OneToMany(mappedBy = "EmployeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public void setAssignedEmployee(EmployeeEntity assignedEmployee) {
		this.assignedEmployee = assignedEmployee;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
