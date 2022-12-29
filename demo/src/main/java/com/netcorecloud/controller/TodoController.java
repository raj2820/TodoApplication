package com.netcorecloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netcorecloud.exception.TodoException;
import com.netcorecloud.model.Todo;
import com.netcorecloud.services.TodoService;
import com.netcorecloud.services.UserService;

@RestController
public class TodoController {


	@Autowired
private	TodoService todoService;
	
	
	
	//@CrossOrigin
	//@RequestMapping(value = "/addNewTask/{userId}", headers = "Accept=application/json", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@PostMapping("/todos/{userId}")
	@CrossOrigin
	public ResponseEntity<Todo> addNewTaskHandler(@RequestBody Todo todoList,@PathVariable("userId") Integer userId ){
		
		Todo todo = todoService.addNewTask(todoList, userId);
		
		return new ResponseEntity<Todo>(todo ,HttpStatus.CREATED);
		
		
	}
	
	
	
	@PutMapping("/updateTask")
	@CrossOrigin
	public ResponseEntity<String> updateTaskHandler(@RequestBody Todo todo ){
		
		
		String str = todoService.updateTask(todo);
		
		return new ResponseEntity<String>(str,HttpStatus.ACCEPTED);
		
		
		
	}
	
	@PutMapping("/updateTaskStatus/{status}/{taskId}")
	@CrossOrigin
	public ResponseEntity<String> updateTaskHandler(@PathVariable("status") boolean status ,@PathVariable("taskId") Integer taskId ) throws TodoException{
		
		
		String str = todoService.updateTaskStatus(status, taskId);
		
		return new ResponseEntity<String>(str,HttpStatus.ACCEPTED);

	}

	@GetMapping("/getAllTasks/{id}")
	@CrossOrigin
	public ResponseEntity<List<Todo>> getAllTasksHandler(@PathVariable Integer id){
		
		List<Todo>list=todoService.getAllTasks(id);
		
		return new ResponseEntity<List<Todo>>(list,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/getAllTasks")
	@CrossOrigin
	public ResponseEntity<List<Todo>> getAllTaskHandler(){
		
		List<Todo> list=todoService.getAllTask();
		
		return new ResponseEntity<List<Todo>>(list,HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/deleteTask/{taskId}/{userId}")
	@CrossOrigin
	public ResponseEntity<String> deleteTaskHandler(@PathVariable("taskId") Integer taskId ,@PathVariable("userId") Integer userId ) throws TodoException{
		
		
		String str = todoService.deltetaskById(taskId,userId);
		
		return new ResponseEntity<String>(str,HttpStatus.OK);
	
	}
	
}
