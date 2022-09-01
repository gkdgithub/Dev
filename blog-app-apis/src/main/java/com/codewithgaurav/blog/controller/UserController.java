package com.codewithgaurav.blog.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithgaurav.blog.dto.UserDto;
import com.codewithgaurav.blog.response.ApiResponse;
import com.codewithgaurav.blog.service.UserService;

@RestController
@RequestMapping(value = "api/users")
public class UserController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		return new ResponseEntity<UserDto>(this.userService.createUser(userDto), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {
		return new ResponseEntity<List<UserDto>>(this.userService.getAllUser(), HttpStatus.OK);
	}

	@GetMapping(value = "/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable(value = "userId") Integer userId) {
		LOGGER.info("UserController: getUserById: " + userId);
		return new ResponseEntity<UserDto>(this.userService.getUserById(userId), HttpStatus.OK);
	}

	@PutMapping(value = "/{userId}")
	public ResponseEntity<UserDto> updatedUser(@Valid @RequestBody UserDto userDto,
			@PathVariable(value = "userId") Integer userId) {
		return ResponseEntity.ok(this.userService.updateUser(userDto, userId));
	}

	@DeleteMapping(value = "/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable(value = "userId") Integer userId) {
		this.userService.deleteUser(userId);
		LOGGER.info("UserController: deleteUser: " + userId);
		return ResponseEntity.ok(ApiResponse.builder().message("User Deleted Successfully").success(true).build());
	}

}
