package com.netcorecloud.service;

import com.netcorecloud.exception.ToDoListException;
import com.netcorecloud.model.TodoList;

public interface ToDoListService {

	
	public String addNewTask(TodoList todoList, Integer userId); 
	
	public String updateTask(TodoList todoList ) throws ToDoListException ;

	public String updateTaskStatus(boolean status ,Integer taskId) throws ToDoListException ;
	
}
