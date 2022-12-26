package com.netcorecloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcorecloud.model.TodoList;
import com.netcorecloud.model.User;
import com.netcorecloud.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public String saveUser(User user) {
		
		
		userDao.save(user);
		
		return "user saved successfully";
	}

	@Override
	public List<TodoList> getAllTasks(Integer id) {
		// TODO Auto-generated method stub
		
		List<TodoList> list=userDao.findById(id).get().getTodoLists();
		
		return list;
	} 
	
	
	
	
}
