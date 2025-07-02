package com.MyProject.TaskService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MyProject.TaskService.model.Task;
import com.MyProject.TaskService.model.TaskStatus;
import com.MyProject.TaskService.model.UserDto;
import com.MyProject.TaskService.service.ITaskService;
import com.MyProject.TaskService.service.UserService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	@Autowired
	private ITaskService service;
	
	@Autowired
	private UserService userService;
	//i have used jwt here so as to not allow any unauthorized person be an admin.
	@PostMapping
	public ResponseEntity<Task> createTask(@RequestBody Task task, @RequestHeader("Authorization") String jwt) throws Exception{
		
		UserDto user = userService.getUserProfile(jwt);
		Task createdTask = service.createTask(task, user.getRole());
		return new ResponseEntity<Task>(createdTask, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> findTaskById(@PathVariable Long id, @RequestHeader("Authorization") String jwt) throws Exception{
		UserDto user = userService.getUserProfile(jwt);
		Task currentTask = service.getTaskById(id);
		return new ResponseEntity<Task>(currentTask, HttpStatus.OK);
		
	}
	
	@GetMapping()
	public ResponseEntity<List<Task>> findAllTasks(@RequestParam(required=false) TaskStatus status, @RequestHeader("Authorization") String jwt){
		UserDto user = userService.getUserProfile(jwt);
        List<Task> allTasks = service.getAllTasks(status);
        return new ResponseEntity<List<Task>>(allTasks, HttpStatus.CREATED);
		
		
	}
	
	@PutMapping("/{id}/user/{userId}/assigned")
	public ResponseEntity<Task> assignTaskToUser(@PathVariable Long id, @PathVariable Long userId, @RequestHeader("Authorization") String jwt) throws Exception{
		UserDto user = userService.getUserProfile(jwt);
		Task assignedTask = service.assignTaskToUser(userId, id);
		return new ResponseEntity<>(assignedTask, HttpStatus.CREATED);

		
		} //means assigning task to a different user.
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateCurrentTask(@PathVariable Long id, @RequestBody Task req, @RequestHeader("Authorization") String jwt ) throws Exception{
		UserDto user = userService.getUserProfile(jwt);
        Task updatedTask = service.updateTask(id, user.getId(), req);
        return new ResponseEntity<Task>(updatedTask, HttpStatus.OK);
		
		
	}
	
	@PutMapping("/{id}/complete")
	public ResponseEntity<Task> completedTask(@PathVariable Long id ) throws Exception{
        Task cTask = service.completeTask(id);
        return new ResponseEntity<Task>(cTask, HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Void> deleteATask(@PathVariable Long id ) throws Exception{
        service.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		
	}
	
	
	
	
	
	
	

}
