package com.netcorecloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netcorecloud.model.TodoList;
import com.netcorecloud.service.ToDoListService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ToDoController {

	@Autowired
private	ToDoListService toDoListService;
	
	@PostMapping("/addNewTask/{id}")
	public ResponseEntity<String> addNewTaskHandler(@RequestBody TodoList todoList,@PathVariable Integer id ){
		
		String str = toDoListService.addNewTask(todoList, id);
		
		return new ResponseEntity<String>(str,HttpStatus.CREATED);
		
		
	}
}
