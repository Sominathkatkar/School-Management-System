package com.terrapay.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import com.terrapay.entity.Auditable;
import com.terrapay.entity.User;


public class AuditorAwareImpl implements AuditorAware<Long> {

	
	
	private User user;

	@Override
	public Optional<Long> getCurrentAuditor() {
	//	String user2 = user.getFirstName();
		return null;

	}
}