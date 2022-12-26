package com.netcorecloud.service;

import java.util.List;

import com.netcorecloud.model.TodoList;
import com.netcorecloud.model.User;

public interface UserService {

	
	public String saveUser(User user); 
	
	public List<TodoList> getAllTasks(Integer id);
	
	
}
