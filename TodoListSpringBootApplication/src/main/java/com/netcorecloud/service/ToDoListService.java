package com.netcorecloud.service;

import com.netcorecloud.model.TodoList;

public interface ToDoListService {

	
	public String addNewTask(TodoList todoList, Integer userId); 
	
}
