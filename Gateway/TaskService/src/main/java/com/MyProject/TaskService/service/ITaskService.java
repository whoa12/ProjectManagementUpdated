package com.MyProject.TaskService.service;

import java.util.List;

import com.MyProject.TaskService.model.Task;
import com.MyProject.TaskService.model.TaskStatus;

public interface ITaskService {
	Task createTask(Task task, String requesterRole ) throws Exception;
	List<Task> getAllTasks(TaskStatus status) ;
	Task updateTask(Long id, Long userId, Task updatedTask) throws Exception;
	Task getTaskById(Long id) throws Exception;
	void deleteTask(Long id);
	Task assignTaskToUser(Long userId, Long taskId) throws Exception;
	List<Task> assignedUsersTask(Long userId, TaskStatus status);
	Task completeTask(Long taskId) throws Exception;

}
