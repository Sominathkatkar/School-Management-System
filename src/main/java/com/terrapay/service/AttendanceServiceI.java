package com.terrapay.service;

import java.util.Date;
import java.util.List;

import com.terrapay.entity.Attendance;
import com.terrapay.entity.User;

public interface AttendanceServiceI {
	public Attendance save(Attendance attendance);
		public Attendance signout(Attendance attendance);
		public boolean checkIfUserExist(String username);
		
		

}
