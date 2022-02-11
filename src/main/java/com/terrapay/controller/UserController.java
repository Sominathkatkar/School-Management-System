package com.terrapay.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.terrapay.entity.User;
import com.terrapay.repository.RoleRepository;
import com.terrapay.repository.UserRepository;
import com.terrapay.service.UserServiceI;
import com.terrapay.service.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceI;
	@Autowired
	private UserRepository userRepository;
	
	//private BCryptPasswordEncoder bCryptPasswordEncoder;
	@PostMapping("/add")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) throws Exception {
		
		User saveUser = userServiceI.saveUser(user);
		return new ResponseEntity<User>(saveUser, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/editUser")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws Exception {
		User saveUser = userServiceI.saveUser(user );
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);

	}
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = userServiceI.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(allUsers);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<User>> deleteUser(@PathVariable Long id) {
		List<User> userList = userServiceI.deleteUsers(id);
		return ResponseEntity.status(HttpStatus.OK).body(userList);
	}
}
