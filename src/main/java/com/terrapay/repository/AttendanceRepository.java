package com.terrapay.repository;







import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.terrapay.entity.Attendance;


@Repository

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
	public Attendance findByUsername(String username);
	
}
