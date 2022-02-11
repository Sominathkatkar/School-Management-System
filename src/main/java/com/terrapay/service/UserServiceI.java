package com.terrapay.service;

import java.util.List;
import java.util.Optional;

import com.terrapay.entity.User;

public interface UserServiceI {
	public User saveUser(User user) throws Exception;
	
	public User updateUser(User user);
	public List<User> getAllUsers();
	public List<User> deleteUsers(Long id);

}
