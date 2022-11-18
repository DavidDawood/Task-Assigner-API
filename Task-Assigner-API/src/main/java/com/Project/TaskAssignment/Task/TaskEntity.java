package com.Project.TaskAssignment.Task;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.Project.TaskAssignment.Employee.EmployeeEntity;
import com.Project.TaskAssignment.Employee.EmployeeServices;

@Entity
@Table(name = "Tasks")
public class TaskEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	@Column
	private String name;
	@Column
	private String description;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "employee_id", nullable = true)
	private EmployeeEntity assignedEmployee;

	public Date getStartDate() {
		return startDate;
	}

	public TaskEntity() {

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
