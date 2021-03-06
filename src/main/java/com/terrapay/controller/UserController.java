package com.terrapay.controller;



import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.terrapay.entity.Attendance;
import com.terrapay.entity.User;

import com.terrapay.service.AttendanceServiceI;
import com.terrapay.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userServiceI;
	
	@Autowired
	private AttendanceServiceI attendanceServiceI;
	 

	@PostMapping("/login")
	public String login(@RequestBody Attendance attendance) {
		attendanceServiceI.save(attendance);
			return "Login sucess";
	}
	
	@PostMapping("/signout")
	public  String logout(@RequestBody Attendance attendance ) throws ParseException  
	{
		
	attendanceServiceI.signout(attendance);
			return "logout success ";
	}
 
	
	@PostMapping("/add")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) throws Exception  {
				User saveUser = userServiceI.saveUser(user);
		return new ResponseEntity<User>(saveUser, HttpStatus.CREATED);
	}

	@PutMapping(value = "/editUser")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws Exception {
		User saveUser = userServiceI.saveUser(user);
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
