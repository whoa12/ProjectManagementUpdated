package com.MyProject.TaskService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MyProject.TaskService.model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

	List<Task> findByAssignedUserId(Long UserId);
	
	

}
