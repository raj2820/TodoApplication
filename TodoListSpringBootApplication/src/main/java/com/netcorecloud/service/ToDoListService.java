package com.netcorecloud.service;

import com.netcorecloud.exception.ToDoListException;
import com.netcorecloud.model.ToDoLists;

public interface ToDoListService {

	
	public ToDoLists addNewTask(ToDoLists todoList, Integer userId); 
	
	public String updateTask(ToDoLists todoList ) throws ToDoListException ;

	public String updateTaskStatus(boolean status ,Integer taskId) throws ToDoListException ;
	
	public String deltetaskById(Integer taskId ,Integer userId)throws ToDoListException;
	
}
