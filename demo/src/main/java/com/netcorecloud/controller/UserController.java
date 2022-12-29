package com.netcorecloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netcorecloud.model.User;
import com.netcorecloud.services.UserService;

@RestController
public class UserController {

	@Autowired
	private	UserService userService;
	
	
	@PostMapping("/Users")
	@CrossOrigin
	public ResponseEntity<User> addUserHandler(@RequestBody User user){
		
		User saveduser=userService.saveUser(user);
		
		return new ResponseEntity<User>(saveduser,HttpStatus.CREATED);
		
		
	}
	
	
	@GetMapping("/getUser/{email}")
	@CrossOrigin
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email){
		User user=userService.getUserByEmail(email);
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
		
	}
	
	
	
	
	
}
