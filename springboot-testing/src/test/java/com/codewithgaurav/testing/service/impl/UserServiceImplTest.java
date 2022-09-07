package com.codewithgaurav.testing.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.codewithgaurav.testing.entity.User;
import com.codewithgaurav.testing.repo.UserRepository;
import com.codewithgaurav.testing.service.UserService;

@SpringBootTest
class UserServiceImplTest {

	@Autowired
	private UserService userService;

	// Since we already have tested repo and so just mock it here in service layer
	@MockBean
	private UserRepository userRepository;

	private User user1, user2, user3, user4;

	@BeforeEach
	void setUp() throws Exception {

		// preparing mock data
		user1 = User.builder().id(1).name("Gaurav").age(29).email("gaurav@gmail.com").address("Bangalore").build();
		user2 = User.builder().id(2).name("Amit").age(30).email("amit@gmail.com").address("Hyd").build();
		user3 = User.builder().id(3).name("Vikas").age(30).email("vikas@gmail.com").address("Bangalore").build();
		user4 = User.builder().id(4).name("Avinash").age(29).email("avinash@gmail.com").address("Pune").build();
	}

	@Test
	void testAddUser() {
		when(userRepository.save(user2)).thenReturn(user2);
		assertEquals(user2, userService.addUser(user2));
	}

	@Test
	void testGetUsers() {
		when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2, user4));
		assertEquals(3, userService.getUsers().size());
	}

	@Test
	void testDeleteUser() {
		User user = User.builder().id(10).name("Ajay").age(27).email("ajay@gmail.com").address("Lucknow").build();
		userService.deleteUser(user);
		verify(userRepository, times(1)).delete(user);
	}

	@Test
	void testGetUserbyAddress() {
		String address = "Bangalore";
		when(userRepository.findByAddress(address)).thenReturn(Stream.of(user1, user3).collect(Collectors.toList()));
		long count = userService.getUserbyAddress(address).stream()
				.filter(u -> u.getAddress().equalsIgnoreCase(address)).count();

		assertEquals(2, count);
	}

	@Test
	void testFindByEmail() {
		String email = "gaurav@gmail.com";
		when(userRepository.findByEmail(email)).thenReturn(user1);
		assertEquals(email, userService.findUserByEmail(email).getEmail());
	}

//	@AfterEach
//	void tearDown() throws Exception {
//	}

}
