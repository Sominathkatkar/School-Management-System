package com.terrapay.entity;

import java.security.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="in_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date inTime;
	
	@Column(name="out_time")
	//@Temporal(TemporalType.TIMESTAMP)
	private Date outTime;
	
	@Column(name="duration")
	private long duration;


}
