package com.terrapay.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.terrapay.entity.Role;
import com.terrapay.entity.User;
import com.terrapay.exception.UserAlreadyExistException;

import com.terrapay.repository.RoleRepository;
import com.terrapay.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServiceI {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) throws Exception {
		Optional<Role> role = roleRepository.findById(user.getRole_Id());
		user.setRole(role.get().getRole());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	
		 if(checkIfUserExist(user.getEmail())){
	            throw new UserAlreadyExistException("User already exists for this email");
	        } 
		 else {
			return userRepository.save(user);
		}
	}

	@Override
	public User updateUser(User user) {
		Optional<Role> role = roleRepository.findById(user.getRole_Id());
		user.setRole(role.get().getRole());
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> list = userRepository.findAll();
		return list;
	}

	@Override
	public List<User> deleteUsers(Long id) {
		User user = userRepository.findById(id).get();
		userRepository.delete(user);
		List<User> list = userRepository.findAll();
		return list;

	}

	@Override
	public User getUserByUsername(String email) {
		 User user = userRepository.getUserByUsername(email);
		user.getPassword();
		return user;
	}

	@Override
	public boolean checkIfUserExist(String email) {
		
		return userRepository.getUserByUsername(email) !=null ? true : false;
	}

}
