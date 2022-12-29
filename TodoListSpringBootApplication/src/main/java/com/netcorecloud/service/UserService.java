package com.netcorecloud.service;

import java.util.List;

import com.netcorecloud.model.ToDoLists;
import com.netcorecloud.model.User;

public interface UserService {

	
	public String saveUser(User user); 
	
	public List<ToDoLists> getAllTasks(Integer id);
	
	public List<ToDoLists> getAllTask();
	
}
