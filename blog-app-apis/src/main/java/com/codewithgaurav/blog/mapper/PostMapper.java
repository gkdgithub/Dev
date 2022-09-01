package com.codewithgaurav.blog.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codewithgaurav.blog.dto.PostDto;
import com.codewithgaurav.blog.entities.Post;

@Component
public class PostMapper {

	@Autowired
	private ModelMapper modelMapper;

	public Post dtoToPost(PostDto postDto) {
		return this.modelMapper.map(postDto, Post.class);
	}

	public PostDto postToDto(Post post) {
		return this.modelMapper.map(post, PostDto.class);
	}

}
