package com.terrapay.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.terrapay.entity.Attendance;

import com.terrapay.entity.User;
import com.terrapay.exception.UserAlreadyExistException;

import com.terrapay.repository.AttendanceRepository;
import com.terrapay.repository.UserRepository;

@Service
public class AttendanceServiceImpl implements AttendanceServiceI {
	@Autowired
	private AttendanceRepository attendenceRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public Attendance save(Attendance attendance) {

		Attendance username = attendenceRepository.findByUsername(attendance.getUsername());

		if (checkIfUserExist(attendance.getUsername())) {
			throw new UserAlreadyExistException("User already exists for this email");
		} else {
			return attendenceRepository.save(attendance);
		}
	}

	@Override
	public Attendance signout(Attendance attendance) {

		Optional<Attendance> user = attendenceRepository.findById(attendance.getId());
		if (user.isPresent()) {
			attendance.setOutTime(new Date(new Date().getTime()));
		} else {
			throw new UsernameNotFoundException("User not found");
		}
	 	return attendenceRepository.save(attendance);
	}

		/*
		 * if(username.getUsername()!=null || attendance.getOutTime()!=null) {
		 * username.setOutTime(new Date(new Date().getTime())); return
		 * attendenceRepository.save(attendance); } else { throw new
		 * UsernameNotFoundException("user not logged in"); }
		 */

	

	@Override
	public boolean checkIfUserExist(String username) {
		return attendenceRepository.findByUsername(username) != null ? true : false;
	}

}
