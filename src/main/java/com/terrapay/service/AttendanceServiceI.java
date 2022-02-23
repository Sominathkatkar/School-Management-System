package com.terrapay.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.terrapay.entity.Attendance;
import com.terrapay.entity.User;

public interface AttendanceServiceI {
	public Attendance save(Attendance attendance );
		public Attendance signout(Attendance attendance ) throws ParseException ;
	//	public boolean checkIfUserExist(Date date);
		public List<Attendance> getDatewiseAttendance(String date);
		public List<Attendance> getAll();
	
		public List<Attendance> getAllBetweenDates(Date startDate, Date endDate);

}
