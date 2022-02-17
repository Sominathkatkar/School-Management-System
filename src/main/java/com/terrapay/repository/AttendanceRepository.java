package com.terrapay.repository;




import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.terrapay.entity.Attendance;


@Repository
@Transactional
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
	public Attendance findByUsername(String username);
	
}
