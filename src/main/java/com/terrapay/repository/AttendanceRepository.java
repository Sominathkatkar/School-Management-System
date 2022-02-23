package com.terrapay.repository;







import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.terrapay.entity.Attendance;


@Repository

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
	public Attendance findByUsername(String username);
	@Query(value = "SELECT * FROM attendance WHERE attendance.in_Time like %?1% ", nativeQuery = true)
	 public List<Attendance> findByDate(@Param("date")  String date);

	@Query(value = "SELECT * FROM attendance WHERE attendance.in_Time >= :startDate AND attendance.in_Time <= :endDate", nativeQuery = true)
	public List<Attendance> findAllBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
}
