package com.codewithgaurav.blog.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

	private Integer postId;

	@NotBlank
	private String title;

	@NotBlank
	private String content;

	private String imageName;

	private String addedDate;

	private CategoryDto category;

	private UserDto user;

}
