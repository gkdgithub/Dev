package com.codewithgaurav.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithgaurav.blog.dto.UserDto;
import com.codewithgaurav.blog.entities.User;
import com.codewithgaurav.blog.exceptions.ResourceNotFoundException;
import com.codewithgaurav.blog.mapper.UserMapper;
import com.codewithgaurav.blog.repository.UserRepo;
import com.codewithgaurav.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User savedUser = this.userRepo.save(userMapper.dtoToUser(userDto));
		return this.userMapper.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = getUserBasedOnId(userId);
		user.setName(userDto.getName());
		user.setEmail(user.getEmail());
		user.setPassword(user.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser = this.userRepo.save(user);
		return this.userMapper.userToDto(updatedUser);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		LOGGER.info("UserServiceImpl: getUserById: " + userId);
		User user = getUserBasedOnId(userId);
		return this.userMapper.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = this.userRepo.findAll();
		LOGGER.info("UserServiceImpl: getAllUser: " + users);
		return users.stream().map(user -> this.userMapper.userToDto(user)).collect(Collectors.toList());
	}

	@Override
	public void deleteUser(Integer userId) {
		LOGGER.info("UserServiceImpl: deleteUser: " + userId);
		User user = getUserBasedOnId(userId);
		this.userRepo.delete(user);
	}

	/**
	 * @param userId
	 * @return
	 */
	private User getUserBasedOnId(Integer userId) {
		return this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with this Id: " + userId));
	}

}
