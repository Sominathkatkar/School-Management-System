
package com.terrapay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.terrapay.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService getUserDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(this.getUserDetailsService());
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable();
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/getAll").hasAuthority("ADMIN")
		.antMatchers("/delete/{id}").hasAuthority("ADMIN")
				.antMatchers("/editUser").hasAuthority("ADMIN")
				.antMatchers("/add").permitAll()
				.antMatchers("/findAll").permitAll()
				.antMatchers("/date/{date}","/date/{startDate}/{endDate}").permitAll()
				.antMatchers("/login").hasAnyAuthority("ADMIN", "TEACHER", "STUDENT", "STAFF")
				.antMatchers("/signout").hasAnyAuthority("ADMIN","TEACHER","STUDENT","STAFF")
				.anyRequest().authenticated().and()

				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().httpBasic();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
}
