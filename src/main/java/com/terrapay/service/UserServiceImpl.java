package com.terrapay.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.rmi.AlreadyBoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.Conflict;

import com.terrapay.entity.Role;
import com.terrapay.entity.User;
import com.terrapay.repository.RoleRepository;
import com.terrapay.repository.UserRepository;

@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) throws Exception {
		Optional<Role> role = roleRepository.findById(user.getRole_Id());
		user.setRole(role.get().getRole());
		User user1 = userRepository.getUserByUsername(user.getEmail());
		if(user1==null) {
		return userRepository.save(user);}
		else {
			throw new Exception("Duplicate entries not allowed");
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

}
