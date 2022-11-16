package com.Project.TaskAssignment.Task;



import org.springframework.data.jpa.repository.JpaRepository;
interface TaskRepository extends JpaRepository<TaskEntity,Long> {

}
