package com.netcorecloud.services;

import java.util.List;

import com.netcorecloud.exception.TodoException;
import com.netcorecloud.model.Todo;

public interface TodoService {

	public Todo addNewTask(Todo todoList, Integer userId); 
	
	public String updateTask(Todo todoList ) throws TodoException ;

	public String updateTaskStatus(boolean status ,Integer taskId) throws TodoException  ;
	
	public String deltetaskById(Integer taskId ,Integer userId)throws TodoException ;
	
public List<Todo> getAllTasks(Integer id);
	
	public List<Todo> getAllTask();
	
}
