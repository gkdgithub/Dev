package com.codewithgaurav.testing.service;

import java.util.List;

import com.codewithgaurav.testing.entity.User;

public interface UserService {

	public User addUser(User user);

	public List<User> getUsers();

	public void deleteUser(User user);

	public List<User> getUserbyAddress(String address);

	public User findUserByEmail(String email);

}
