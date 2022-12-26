package com.netcorecloud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.netcorecloud.model.TodoList;
import com.netcorecloud.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	
	
}
