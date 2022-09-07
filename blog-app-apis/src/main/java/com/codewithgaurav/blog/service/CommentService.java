package com.codewithgaurav.blog.service;

import java.util.List;

import com.codewithgaurav.blog.dto.CommentDto;
import com.codewithgaurav.blog.response.PaginationResponse;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Integer userId, Integer postId);

	List<CommentDto> getCommentByUser(Integer userId);

	List<CommentDto> getCommentByPost(Integer postId);

	CommentDto getCommentById(Integer commentId);

	PaginationResponse getAllComments(Integer pageNumber, Integer pageSize);

	CommentDto updateComment(CommentDto commentDto, Integer commentId);

	void deleteComment(Integer commentId);
}
