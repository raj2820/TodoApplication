package com.netcorecloud.services;


import com.netcorecloud.exception.UserException;

import com.netcorecloud.model.User;


public interface UserService {

	
	public User saveUser(User user); 
	
	public User getUserByEmail(String email) throws UserException;
	
}
