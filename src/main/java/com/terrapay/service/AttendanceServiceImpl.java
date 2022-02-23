package com.terrapay.service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;

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

		 User username = userRepository.getUserByUsername(attendance.getUsername());
		 attendance.setUsername(username.getEmail());
		Date inTime = new Date(new Date().getTime());
		String var = inTime.toString();
		attendance.setInTime( new Date(new Date().getTime()));
		//attendanceServiceI.save(attendance);
		List<Attendance> byDate = attendenceRepository.findByDate(var);
		if(byDate.isEmpty()) {
			return attendenceRepository.save(attendance);
		//if (checkIfUserExist(attendance.getInTime())) {
		//	throw new UserAlreadyExistException("User already login");
		} 
		else {
			throw new UserAlreadyExistException("User already login");
		}
	}

	@Override
	public Attendance signout(Attendance attendance) throws java.text.ParseException  {

		Optional<Attendance> user = attendenceRepository.findById(attendance.getId());
		
		
		//Date duration = start - end;
		if (user.isPresent()) {
			Attendance userob =  user.get();
			attendance.setInTime(userob.getInTime());
			attendance.setUsername(userob.getUsername());
			//LocalDateTime local =LocalDateTime.now();
			
			Date start= userob.getInTime(); 
			LocalDate local=LocalDate.now();
		//	Date sa =local.toString();
			attendance.setOutTime(new Date(new Date().getTime()));
		}
			
			/*
			String s = userob.getInTime().toString();
			String e = attendance.getOutTime().toString();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
			try {
			Date d = sdf.parse(s);
			Date d1 = sdf.parse(e);
			long duration = d1.getTime() - d.getTime();
			attendance.setDuration(duration);
			}
			catch (ParseException e1) {
			    e1.printStackTrace();
			
			}
		}*/
			
			//long duration=new Date().getTime(user.get().getInTime()-user.get().getOutTime()).
			
		 else {
			throw new UsernameNotFoundException("User not found");
		}
	 	return attendenceRepository.save(attendance);
	}

		

	

	/*
	 * @Override public boolean checkIfUserExist(Date date) { return
	 * attendenceRepository.findByDate(date) != null ? true : false; }
	 */
	@Override
	public List<Attendance> getDatewiseAttendance(String date) {
	
		return attendenceRepository.findByDate(date);
	}

	@Override
	public List<Attendance> getAll() {
		
		return attendenceRepository.findAll();
	}

	@Override
	public List<Attendance> getAllBetweenDates(Date startDate, Date endDate) {
		
		return attendenceRepository.findAllBetweenDates(startDate, endDate);
	}

}
