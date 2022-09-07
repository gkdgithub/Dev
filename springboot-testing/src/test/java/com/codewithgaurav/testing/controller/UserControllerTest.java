package com.codewithgaurav.testing.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.codewithgaurav.testing.entity.User;
import com.codewithgaurav.testing.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	private User user1, user2, user3, user4;

	private static ObjectMapper mapper = new ObjectMapper();

	@BeforeEach
	void setUp() throws Exception {

		// preparing mock data
		user1 = User.builder().id(1).name("Gaurav").age(29).email("gaurav@gmail.com").address("Bangalore").build();
		user2 = User.builder().id(2).name("Amit").age(30).email("amit@gmail.com").address("Hyd").build();
		user3 = User.builder().id(3).name("Vikas").age(30).email("vikas@gmail.com").address("Bangalore").build();
		user4 = User.builder().id(4).name("Avinash").age(29).email("avinash@gmail.com").address("Pune").build();
	}

	@Test
	void testSaveUser() throws Exception {

		when(userService.addUser(user1)).thenReturn(user1);

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.post("/save").contentType(MediaType.APPLICATION_JSON)
						.content(userToString(user1)).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		String resultAsString = getResponseAsString(mvcResult);

		User user = stringToUser(resultAsString);
		assertEquals(user1.getAge(), user.getAge());

		// we can use below code also to test add user method
//		mockMvc.perform(MockMvcRequestBuilders.post("/save").contentType(MediaType.APPLICATION_JSON)
//				.content(mapper.writeValueAsString(user1)).accept(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void testFindAllUsers() throws Exception {

		when(userService.getUsers()).thenReturn(Arrays.asList(user1, user2, user4));

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/getUsers").accept(MediaType.APPLICATION_JSON)).andReturn();
		String resultAsString = getResponseAsString(mvcResult);

		User[] usersArray = stringToUser(resultAsString);
		List<User> usersList = Arrays.asList(usersArray);

		assertEquals(3, usersList.size());

		// we can use below code also to test add user method
//		mockMvc.perform(MockMvcRequestBuilders.get("/getUsers").accept(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void testRemoveUser() throws Exception {

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.delete("/remove").contentType(MediaType.APPLICATION_JSON)
						.content(userToString(user3)).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		String resultAsString = getResponseAsString(mvcResult);

		assertEquals("User deleted !", resultAsString);

		// we can use below code also to test add user method
//		mockMvc.perform(MockMvcRequestBuilders.delete("/remove").contentType(MediaType.APPLICATION_JSON)
//				.content(mapper.writeValueAsString(user2)).accept(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void testFindUserByAddress() throws Exception {

		String address = "Bangalore";
		when(userService.getUserbyAddress(address)).thenReturn(Stream.of(user1, user3).collect(Collectors.toList()));

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getUserByAddress/{address}", "Bangalore")
				.accept(MediaType.APPLICATION_JSON)).andReturn();

		String resultAsString = getResponseAsString(mvcResult);
		User[] users = stringToUser(resultAsString);

		assertEquals(2, users.length);

		// we can use below code also to test add user method
//		mockMvc.perform(
//				MockMvcRequestBuilders.get("/getUserByAddress/{address}", "Hyd").accept(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void testFindUserByEmail() throws Exception {

		String email = "gaurav@gmail.com";
		when(userService.findUserByEmail(email)).thenReturn(user1);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getUserByEmail/{email}", "gaurav@gmail.com")
				.accept(MediaType.APPLICATION_JSON)).andReturn();
		String resultAsString = getResponseAsString(mvcResult);

		User user = stringToUser(resultAsString);

		assertEquals(email, user.getEmail());

		// we can use below code also to test add user method
//		mockMvc.perform(MockMvcRequestBuilders.get("/getUserByEmail/{email}", "avinash@gmail.com")
//				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
	}

	private String userToString(User user) throws JsonProcessingException {
		return mapper.writeValueAsString(user);
	}

	@SuppressWarnings("unchecked")
	private <T> T stringToUser(String resultAsString) throws JsonProcessingException, JsonMappingException {
		if (resultAsString.startsWith("[")) {
			return (T) mapper.readValue(resultAsString, User[].class);
		} else {
			return (T) mapper.readValue(resultAsString, User.class);
		}

	}

	private String getResponseAsString(MvcResult mvcResult) throws UnsupportedEncodingException {
		return mvcResult.getResponse().getContentAsString();
	}

//	@AfterEach
//	void tearDown() throws Exception {
//	}

}
