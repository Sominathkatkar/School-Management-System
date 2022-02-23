package com.terrapay.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.terrapay.entity.Attendance;
import com.terrapay.service.AttendanceServiceI;

@RestController
public class AttendanceController {
	
	@Autowired
	private AttendanceServiceI attendanceServiceI;
	
	@GetMapping("/date/{date}")
	public ResponseEntity<List<Attendance>> getAttendance(@PathVariable String date) {
		List<Attendance> bydate = attendanceServiceI.getDatewiseAttendance(date);
		return ResponseEntity.status(HttpStatus.OK).body(bydate);
}
	
	@GetMapping("/date/{startDate}/{endDate}")
	public ResponseEntity<List<Attendance>> getAttendanceBeteenDates(@PathVariable @DateTimeFormat
			(pattern = "yyyy-MM-dd") Date startDate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
		List<Attendance> allBetweenDates = attendanceServiceI.getAllBetweenDates(startDate, endDate);
		return ResponseEntity.status(HttpStatus.OK).body(allBetweenDates);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Attendance>> getAll() {
		List<Attendance> attendance = attendanceServiceI.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(attendance);
	}
}
