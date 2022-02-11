/*
 * package com.terrapay.service;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * 
 * import com.terrapay.config.CustomUserDetails; import
 * com.terrapay.entity.User; import com.terrapay.repository.UserRepository;
 * 
 * public class CustomUserDetailsService implements UserDetailsService {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * @Override public UserDetails loadUserByUsername(String email) throws
 * UsernameNotFoundException { User username =
 * userRepository.getUserByUsername(email); if(username==null) { throw new
 * UsernameNotFoundException("User not found"); } CustomUserDetails
 * customUserDetails = new CustomUserDetails(username); return
 * customUserDetails; }
 * 
 * }
 */