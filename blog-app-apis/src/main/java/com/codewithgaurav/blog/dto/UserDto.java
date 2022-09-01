package com.codewithgaurav.blog.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private Integer id;
	@NotBlank
	@Size(min = 3, max = 8, message = "username must be minimum of length of 3 !")
	private String name;
	@Email(message = "Email is not a valid email address !")
	private String email;
	@NotBlank
	@Size(min = 3, max = 10, message = "password must be minimum of length of 3 !")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@NotBlank
	private String about;

}
