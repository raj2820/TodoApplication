package com.netcorecloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcorecloud.model.ToDoLists;
import com.netcorecloud.model.User;
import com.netcorecloud.repository.ToDoDao;
import com.netcorecloud.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private ToDoDao toDoDao;
	@Override
	public String saveUser(User user) {
		
		
		userDao.save(user);
		
		return "user saved successfully";
	}

	@Override
	public List<ToDoLists> getAllTasks(Integer id) {
		// TODO Auto-generated method stub
		
		List<ToDoLists> list=userDao.findById(id).get().getTodoLists();
		
		return list;
	}

	@Override
	public List<ToDoLists> getAllTask() {
		List<ToDoLists> list=toDoDao.findAll();
		return list;
	} 
	
	
	
	
}
