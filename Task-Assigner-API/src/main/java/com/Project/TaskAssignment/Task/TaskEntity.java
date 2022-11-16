package com.Project.TaskAssignment.Task;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.Project.TaskAssignment.Employee.EmployeeEntity;

@Entity
@Table(name = "Task")
public class TaskEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	@Column
	private String name;
	@Column
	private String description;

	@ManyToOne
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
