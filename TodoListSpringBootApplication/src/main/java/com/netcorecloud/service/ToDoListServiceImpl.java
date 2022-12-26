package com.netcorecloud.service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcorecloud.exception.ToDoListException;
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
	@Override
	public String updateTask(TodoList todoList)throws ToDoListException {

Optional<TodoList> todo = toDoDao.findById(todoList.getTodoId());

TodoList utodo=todo.get();

utodo.setUpdatedDate(LocalDate.now());
utodo.setTaskName(todoList.getTaskName());
utodo.setTodo(todoList.getTodo());

		return "Task updated successfully !";
		
	}
	@Override
	public String updateTaskStatus(boolean status, Integer taskId) throws ToDoListException {
		Optional<TodoList> todo = toDoDao.findById(taskId);

		if(!todo.isPresent()) {
			throw new ToDoListException("Task not found");
		}
		
		TodoList utodo=todo.get();
		utodo.setStatus(status);
		toDoDao.save(utodo);
		return "Status updated !";
	}

	
	
	
	
	
}
