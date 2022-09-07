package com.codewithgaurav.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.codewithgaurav.blog.dto.CommentDto;
import com.codewithgaurav.blog.entities.Comment;
import com.codewithgaurav.blog.entities.Post;
import com.codewithgaurav.blog.entities.User;
import com.codewithgaurav.blog.exceptions.ResourceNotFoundException;
import com.codewithgaurav.blog.mapper.CommentMapper;
import com.codewithgaurav.blog.repository.CommentRepo;
import com.codewithgaurav.blog.repository.PostRepo;
import com.codewithgaurav.blog.repository.UserRepo;
import com.codewithgaurav.blog.response.PaginationResponse;
import com.codewithgaurav.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private CommentMapper commentMapper;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PostRepo postRepo;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer userId, Integer postId) {

		User user = getUserById(userId);

		Post post = getPostById(postId);

		Comment comment = commentMapper.dtoToComment(commentDto);
		comment.setUser(user);
		comment.setPost(post);

		return commentMapper.commentToDto(commentRepo.save(comment));
	}

	@Override
	public List<CommentDto> getCommentByUser(Integer userId) {
		User user = getUserById(userId);
		return commentRepo.findByUser(user).stream().map(comment -> commentMapper.commentToDto(comment))
				.collect(Collectors.toList());
	}

	@Override
	public List<CommentDto> getCommentByPost(Integer postId) {
		Post post = getPostById(postId);
		return commentRepo.findByPost(post).stream().map(comment -> commentMapper.commentToDto(comment))
				.collect(Collectors.toList());
	}

	@Override
	public PaginationResponse getAllComments(Integer pageNumber, Integer pageSize) {

		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Comment> pages = commentRepo.findAll(pageable);
		List<Comment> comments = pages.getContent();

		List<CommentDto> commentsDtos = comments.stream().map(comment -> commentMapper.commentToDto(comment))
				.collect(Collectors.toList());

		PaginationResponse paginationResponse = PaginationResponse.builder().content(commentsDtos)
				.pageNumber(pages.getNumber()).pageSize(pages.getSize()).totalElements(pages.getTotalElements())
				.totalPage(pages.getTotalPages()).lastPage(pages.isLast()).build();
		return paginationResponse;
	}

	@Override
	public CommentDto updateComment(CommentDto commentDto, Integer commentId) {
		Comment comment = getCommentBasedOnId(commentId);
		comment.setCommentMessage(commentDto.getCommentMessage());
		
		Comment updatedComment = commentRepo.save(comment);
		return commentMapper.commentToDto(updatedComment);
	}

	@Override
	public CommentDto getCommentById(Integer commentId) {
		Comment comment = getCommentBasedOnId(commentId);
		return commentMapper.commentToDto(comment);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = getCommentBasedOnId(commentId);
		commentRepo.delete(comment);
	}

	/**
	 * @param userId
	 * @return
	 */
	private User getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with this Id: " + userId));
		return user;
	}

	/**
	 * @param postId
	 * @return
	 */
	private Post getPostById(Integer postId) {
		return postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post not found with this Id: " + postId));
	}

	/**
	 * @param commentId
	 * @return
	 */
	private Comment getCommentBasedOnId(Integer commentId) {
		Comment comment = commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment not found with this Id: " + commentId));
		return comment;
	}

}
