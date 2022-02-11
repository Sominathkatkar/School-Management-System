package com.terrapay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.terrapay.entity.Attendence;

public interface AttendenceRepository extends JpaRepository<Attendence, Long> {

}
