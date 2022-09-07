package com.codewithgaurav.blog.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codewithgaurav.blog.dto.CommentDto;
import com.codewithgaurav.blog.entities.Comment;

@Component
public class CommentMapper {

	@Autowired
	private ModelMapper modelMapper;

	public Comment dtoToComment(CommentDto commentDto) {
		return modelMapper.map(commentDto, Comment.class);
	}

	public CommentDto commentToDto(Comment comment) {
		return modelMapper.map(comment, CommentDto.class);
	}
}
