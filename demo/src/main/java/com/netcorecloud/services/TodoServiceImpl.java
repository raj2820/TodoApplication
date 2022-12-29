package com.netcorecloud.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcorecloud.exception.TodoException;
import com.netcorecloud.model.Todo;
import com.netcorecloud.model.User;
import com.netcorecloud.repositories.TodoDao;
import com.netcorecloud.repositories.UserDao;

@Service
public class TodoServiceImpl implements TodoService  {
	@Autowired
	private TodoDao todoDao;
	
	@Autowired
	private UserDao userDao;
	@Override
	public Todo addNewTask(Todo todoList, Integer userId) {
	Optional<User> optuser = userDao.findById(userId);
		
		todoList.setCreatedDate(LocalDate.now());
		todoList.setUser(optuser.get());
		
		return todoDao.save(todoList);
	
	}

	@Override
	public String updateTask(Todo todoList) throws TodoException {
		Optional<Todo> todo = todoDao.findById(todoList.getTodoId());
		if(!todo.isPresent()) {
			throw new TodoException("Task not found");
		}
		Todo utodo=todo.get();

		utodo.setUpdatedDate(LocalDate.now());
		utodo.setTaskName(todoList.getTaskName());
		utodo.setTodoDesc(todoList.getTodoDesc());
		todoDao.save(utodo);
				return "Task updated successfully !";
	}

	@Override
	public String updateTaskStatus(boolean status, Integer taskId) throws TodoException {
		Optional<Todo> todo = todoDao.findById(taskId);

		if(!todo.isPresent()) {
			throw new TodoException("Task not found");
		}
		
		Todo utodo=todo.get();
		utodo.setStatus(status);
		todoDao.save(utodo);
		return "Status updated !";
	}

	@Override
	public String deltetaskById(Integer taskId, Integer userId) throws TodoException {
		Optional<User> uopt=userDao.findById(userId);
		User user=uopt.get();
		
		List<Todo> tlist=user.getTodoList();
		
		for(Todo t:tlist) {
			if(t.getTodoId().equals(taskId)) {
				Optional<Todo> todo = todoDao.findById(taskId);
				if(!todo.isPresent()) {
					throw new TodoException("Task not found");
					
				}
				todoDao.delete(todo.get());
			}
	}
		return "task deleted";
	}

	@Override
	public List<Todo> getAllTasks(Integer id) {
		
		List<Todo> list=userDao.findById(id).get().getTodoList();
		
		return list;
	}

	@Override
	public List<Todo> getAllTask() {
		List<Todo> list=todoDao.findAll();
		return list;
	}

	
	
	
	
}
