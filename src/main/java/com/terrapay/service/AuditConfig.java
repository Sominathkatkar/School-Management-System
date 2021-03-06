package com.terrapay.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.terrapay.entity.User;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditConfig {
	@Bean
	public AuditorAware<Long> auditorAware() {
		return new AuditorAwareImpl();
	}
}
