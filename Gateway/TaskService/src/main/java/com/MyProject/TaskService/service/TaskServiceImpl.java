package com.MyProject.TaskService.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyProject.TaskService.model.Task;
import com.MyProject.TaskService.model.TaskStatus;
import com.MyProject.TaskService.repository.TaskRepo;

@Service
public class TaskServiceImpl implements ITaskService{
	
	@Autowired
	private TaskRepo repo;

	@Override
	public Task createTask(Task task, String requesterRole) throws Exception {
		if(!requesterRole.equals("ROLE_ADMIN")) {
			throw new Exception("Only an admin can create a task!");
		}
		task.setStatus(TaskStatus.PENDING);
		task.setCreatedAt(LocalDateTime.now());
		return repo.save(task);
	}

	@Override
	public List<Task> getAllTasks(TaskStatus status) {
		List<Task> allTasks = repo.findAll();
		List<Task> filteredTask = allTasks.stream().filter(
				task -> status==null || task.getStatus().name().equalsIgnoreCase(status.toString())
				).collect(Collectors.toList());
		
				
		return filteredTask;
	}

	@Override
	public Task getTaskById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(() -> new Exception("Task not Found!"));
	}

	@Override
	public void deleteTask(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}
	
	@Override
	public Task updateTask(Long id, Long userId, Task updatedTask) throws Exception {
		Task existingTask = getTaskById(id);
		if(updatedTask.getTitle()!=null) {
			existingTask.setTitle(updatedTask.getTitle());
		}
		if(updatedTask.getImage()!=null) {
			existingTask.setImage(updatedTask.getImage());
		}
		
		if(updatedTask.getDescription()!=null) {
			existingTask.setDescription(updatedTask.getDescription());
			
		}
		if(updatedTask.getStatus()!=null) {
			existingTask.setStatus(updatedTask.getStatus());
		}
		return repo.save(existingTask);
		
	}

	@Override
	public Task assignTaskToUser(Long userId, Long taskId) throws Exception {
		Task task = getTaskById(taskId);
		task.setAssignedUserId(userId);
		task.setStatus(TaskStatus.DONE);
		return repo.save(task);
		
		
		
	}

	@Override
	public Task completeTask(Long taskId) throws Exception {
		Task task = getTaskById(taskId);
		task.setStatus(TaskStatus.DONE);
		return repo.save(task);
	}

	@Override
	public List<Task> assignedUsersTask(Long userId, TaskStatus status) {
		List<Task> allTasks = repo.findByAssignedUserId(userId);
		List<Task> filteredTask = allTasks.stream().filter(
				task -> status==null || task.getStatus().name().equalsIgnoreCase(status.toString())
				).collect(Collectors.toList());
		
				
		return filteredTask;
		
		
	}

}
