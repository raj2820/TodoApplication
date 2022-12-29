package com.netcorecloud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcorecloud.exception.UserException;
import com.netcorecloud.model.User;
import com.netcorecloud.repositories.TodoDao;
import com.netcorecloud.repositories.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	
	@Override
	public User saveUser(User user) {

		return 	userDao.save(user);
		
		
	}


	@Override
	public User getUserByEmail(String email) throws UserException {
		User user = userDao.findByEmail(email);
		if(user==null) {
			throw new UserException("User not found");
		}
		
		return user;
	}

}
