package com.netcorecloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netcorecloud.model.TodoList;

@Repository
public interface ToDoDao extends JpaRepository<TodoList, Integer>{

}
