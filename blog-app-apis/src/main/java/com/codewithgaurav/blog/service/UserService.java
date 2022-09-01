package com.codewithgaurav.blog.service;

import java.util.List;

import com.codewithgaurav.blog.dto.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto userDto, Integer id);
	
	UserDto getUserById(Integer id);
	
	List<UserDto> getAllUser();
	
	void deleteUser(Integer id);
}
