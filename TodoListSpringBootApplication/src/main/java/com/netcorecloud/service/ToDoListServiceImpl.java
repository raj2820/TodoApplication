package com.netcorecloud.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcorecloud.model.TodoList;
import com.netcorecloud.model.User;
import com.netcorecloud.repository.ToDoDao;
import com.netcorecloud.repository.UserDao;

@Service
public class ToDoListServiceImpl implements ToDoListService{
	@Autowired
	private ToDoDao toDoDao;

	@Autowired
	private UserDao userDao;
	@Override
	public String addNewTask(TodoList todoList, Integer userId) {
		
		Optional<User> optuser = userDao.findById(userId);
		
		todoList.setCreatedDate(LocalDate.now());
		todoList.setUser(optuser.get());
		
		toDoDao.save(todoList);
		
		return "Task added succesfully";
	}

	
	
	
	
	
}
