package com.netcorecloud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netcorecloud.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	public  User findByEmail(String email);
	
}
