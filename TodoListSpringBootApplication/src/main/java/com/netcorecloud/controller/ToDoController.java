package com.netcorecloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netcorecloud.exception.ToDoListException;
import com.netcorecloud.model.TodoList;
import com.netcorecloud.service.ToDoListService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ToDoController {

	@Autowired
private	ToDoListService toDoListService;
	
	@PostMapping("/addNewTask/{userId}")
	public ResponseEntity<String> addNewTaskHandler(@RequestBody TodoList todoList,@PathVariable("userId") Integer userId ){
		
		String str = toDoListService.addNewTask(todoList, userId);
		
		return new ResponseEntity<String>(str,HttpStatus.CREATED);
		
		
	}
	
	
	@PutMapping("/updateTask/{userId}")
	public ResponseEntity<String> updateTaskHandler(@RequestBody TodoList todoList ){
		
		
		String str = toDoListService.updateTask(todoList);
		
		return new ResponseEntity<String>(str,HttpStatus.ACCEPTED);
		
		
		
	}
	
	@PutMapping("/updateTaskStatus/{taskId}")
	public ResponseEntity<String> updateTaskHandler(@RequestParam boolean status,@PathVariable("taskId") Integer taskId ) throws ToDoListException{
		
		
		String str = toDoListService.updateTaskStatus(status, taskId);
		
		return new ResponseEntity<String>(str,HttpStatus.ACCEPTED);
		
		
		
	}
	
	
	
}
