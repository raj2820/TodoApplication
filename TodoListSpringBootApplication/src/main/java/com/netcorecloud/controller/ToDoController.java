package com.netcorecloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netcorecloud.exception.ToDoListException;
import com.netcorecloud.model.ToDoLists;
import com.netcorecloud.service.ToDoListService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ToDoController {

	@Autowired
private	ToDoListService toDoListService;
	
	
	
	//@CrossOrigin
	//@RequestMapping(value = "/addNewTask/{userId}", headers = "Accept=application/json", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@PostMapping("/addNewTask/{userId}")
	public ResponseEntity<ToDoLists> addNewTaskHandler(@RequestBody ToDoLists todoList,@PathVariable("userId") Integer userId ){
		
		ToDoLists todo = toDoListService.addNewTask(todoList, userId);
		
		return new ResponseEntity<ToDoLists>(todo ,HttpStatus.CREATED);
		
		
	}
//	@PostMapping("/posts")
//	public ResponseEntity<String> addNewTaskHandler(@RequestBody TodoList todoList ){
//		
//		String str = toDoListService.addNewTask(todoList, 1);
//		
//		return new ResponseEntity<String>(str,HttpStatus.OK);
//		
//		
//	}
	
	@PutMapping("/updateTask/{userId}")
	public ResponseEntity<String> updateTaskHandler(@RequestBody ToDoLists todoList ){
		
		
		String str = toDoListService.updateTask(todoList);
		
		return new ResponseEntity<String>(str,HttpStatus.ACCEPTED);
		
		
		
	}
	
	@PutMapping("/updateTaskStatus/{taskId}")
	public ResponseEntity<String> updateTaskHandler(@RequestParam boolean status,@PathVariable("taskId") Integer taskId ) throws ToDoListException{
		
		
		String str = toDoListService.updateTaskStatus(status, taskId);
		
		return new ResponseEntity<String>(str,HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/deleteTaskStatus/{taskId}/{userId}")
	@CrossOrigin
	public ResponseEntity<String> deleteTaskHandler(@PathVariable("taskId") Integer taskId ,@PathVariable("userId") Integer userId ) throws ToDoListException{
		
		
		String str = toDoListService.deltetaskById(taskId,userId);
		
		return new ResponseEntity<String>(str,HttpStatus.OK);
	
	}
	
	
}
