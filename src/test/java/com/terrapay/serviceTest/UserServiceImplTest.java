package com.terrapay.serviceTest;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.terrapay.entity.User;
import com.terrapay.repository.UserRepository;
import com.terrapay.service.UserServiceI;

@SpringBootTest
public class UserServiceImplTest {
	@MockBean
	private UserRepository repository;

	@Autowired
	private UserServiceI userServiceI;
	
	@BeforeEach
	void setUp() {
//		User user = User.builder()
//			.id(1)
//				.firstName("Amol")
//				.lastName("Sonawane");
//				
	}

}
