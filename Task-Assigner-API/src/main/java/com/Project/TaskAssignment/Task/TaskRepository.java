package com.Project.TaskAssignment.Task;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface TaskRepository extends JpaRepository<TaskEntity,Long> {
	List<TaskEntity> findByAssignedEmployeeIsNull();
	List<TaskEntity> findByAssignedEmployeeIsNotNull();
}
