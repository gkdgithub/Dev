package com.codewithgaurav.testing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewithgaurav.testing.entity.User;
import com.codewithgaurav.testing.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping(value = "/save")
	public User saveUser(@RequestBody User user) {
		return service.addUser(user);
	}

	@GetMapping("/getUsers")
	public List<User> findAllUsers() {
		return service.getUsers();
	}

	@DeleteMapping(value = "/remove")
	public String removeUser(@RequestBody User user) {
		service.deleteUser(user);
		return "User deleted !";
	}

	@GetMapping("/getUserByAddress/{address}")
	public List<User> findUserByAddress(@PathVariable String address) {
		return service.getUserbyAddress(address);
	}

	@GetMapping("/getUserByEmail/{email}")
	public User findUserByEmail(@PathVariable String email) {
		return service.findUserByEmail(email);
	}

}
