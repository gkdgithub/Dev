package com.codewithgaurav.testing.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codewithgaurav.testing.entity.User;

@SpringBootTest
//@DataJpaTest
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@BeforeEach
	void setUp() {
		User user1 = User.builder().name("Gaurav").age(29).email("gaurav@gmail.com").address("Bangalore").build();
		User user2 = User.builder().name("Amit").age(30).email("amit@gmail.com").address("Hyd").build();
		User user3 = User.builder().name("Vikas").age(30).email("vikas@gmail.com").address("Bangalore").build();
		User user4 = User.builder().name("Avinash").age(29).email("avinash@gmail.com").address("Pune").build();
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4));
	}

	@Test
	void testFindByAddress() {
		int expectedSize = 2;
		List<User> users = userRepository.findByAddress("Bangalore");
		System.out.println("testFindByAddress : "+users);
		assertEquals(expectedSize, users.size());
	}
	
	@Test
	void testFindByEmail() {
		String expected = "amit@gmail.com";
		User user = userRepository.findByEmail("amit@gmail.com");
		System.out.println("testFindByEmail : "+user.toString());
		assertEquals(expected, user.getEmail());
	}

	@AfterEach
	void tearDown() {
		userRepository.deleteAll();
	}

}
