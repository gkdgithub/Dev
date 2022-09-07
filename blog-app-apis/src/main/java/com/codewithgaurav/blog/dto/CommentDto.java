package com.codewithgaurav.blog.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

	private Integer commentId;

	@NotBlank
	private String commentMessage;

	private PostDto post;

	private UserDto user;

}
