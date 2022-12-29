package com.netcorecloud.service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcorecloud.exception.ToDoListException;
import com.netcorecloud.model.ToDoLists;
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
	public ToDoLists addNewTask(ToDoLists todoList, Integer userId) {
		
		Optional<User> optuser = userDao.findById(userId);
		
		todoList.setCreatedDate(LocalDate.now());
		todoList.setUser(optuser.get());
		
		return toDoDao.save(todoList);
		
		
	}
	@Override
	public String updateTask(ToDoLists todoList)throws ToDoListException {

Optional<ToDoLists> todo = toDoDao.findById(todoList.getTodoId());
if(!todo.isPresent()) {
	throw new ToDoListException("Task not found");
}
ToDoLists utodo=todo.get();

utodo.setUpdatedDate(LocalDate.now());
utodo.setTaskName(todoList.getTaskName());
utodo.setTodo(todoList.getTodo());
toDoDao.save(utodo);
		return "Task updated successfully !";
		
	}
	@Override
	public String updateTaskStatus(boolean status, Integer taskId) throws ToDoListException {
		Optional<ToDoLists> todo = toDoDao.findById(taskId);

		if(!todo.isPresent()) {
			throw new ToDoListException("Task not found");
		}
		
		ToDoLists utodo=todo.get();
		utodo.setStatus(status);
		toDoDao.save(utodo);
		return "Status updated !";
	}
	@Override
	public String deltetaskById(Integer taskId ,Integer userId) throws ToDoListException {
		
		Optional<User> uopt=userDao.findById(userId);
		User user=uopt.get();
		
		List<ToDoLists> tlist=user.getTodoLists();
		
		for(ToDoLists t:tlist) {
			if(t.getTodoId().equals(taskId)) {
				Optional<ToDoLists> todo = toDoDao.findById(taskId);
				if(!todo.isPresent()) {
					throw new ToDoListException("Task not found");
					
				}
				toDoDao.delete(todo.get());
			}
		}
		
		
	

		
		
		
		
		
		return "task deleted";
		
	}

	
	
	
	
	
}
