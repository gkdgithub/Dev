package com.codewithgaurav.testing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithgaurav.testing.entity.User;
import com.codewithgaurav.testing.repo.UserRepository;
import com.codewithgaurav.testing.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	public User addUser(User user) {
		User returnUser = repository.save(user);
		System.out.println("UserServiceImpl : addUser : "+returnUser);
		return returnUser;
	}

	public List<User> getUsers() {
		List<User> users = repository.findAll();
		System.out.println("UserServiceImpl : getUsers : " + users);
		return users;
	}

	public void deleteUser(User user) {
		repository.delete(user);
	}

	public List<User> getUserbyAddress(String address) {
		List<User> users =  repository.findByAddress(address);
		System.out.println("UserServiceImpl : getUserbyAddress : "+users);
		return users;
	}
	
	public User findUserByEmail(String email) {
		User user = repository.findByEmail(email);
		System.out.println("UserServiceImpl : findUserByEmail : "+user);
		return user;
	}

}
