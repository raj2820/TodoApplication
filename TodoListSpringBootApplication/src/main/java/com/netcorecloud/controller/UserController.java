package com.netcorecloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netcorecloud.model.TodoList;
import com.netcorecloud.model.User;
import com.netcorecloud.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class UserController {

	@Autowired
	private	UserService userService;
	
	
	@PostMapping("/addUsers")
	public ResponseEntity<String> addUserHandler(@RequestBody User user){
		
		String str=userService.saveUser(user);
		
		return new ResponseEntity<String>(str,HttpStatus.CREATED);
		
		
	}
	
	
	@GetMapping("/getAllTasks/{id}")
	public ResponseEntity<List<TodoList>> getAllTasksHandler(@PathVariable Integer id){
		
		List<TodoList> list=userService.getAllTasks(id);
		
		return new ResponseEntity<List<TodoList>>(list,HttpStatus.OK);
		
		
	}
	
}
