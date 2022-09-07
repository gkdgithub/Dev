package com.codewithgaurav.blog.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codewithgaurav.blog.dto.CommentDto;
import com.codewithgaurav.blog.response.ApiResponse;
import com.codewithgaurav.blog.response.PaginationResponse;
import com.codewithgaurav.blog.service.CommentService;

@RestController
@RequestMapping("api/")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping(value = "user/{userId}/post/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@Valid @RequestBody CommentDto commentDto,
			@PathVariable Integer userId, @PathVariable Integer postId) {
		CommentDto createdComment = commentService.createComment(commentDto, userId, postId);
		return new ResponseEntity<CommentDto>(createdComment, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "comment/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) {
		commentService.deleteComment(commentId);
		return ResponseEntity.ok(ApiResponse.builder().message("Comment Deleted Successfully").success(true)
				.status(String.valueOf(HttpStatus.OK)).timeStamp(String.valueOf(LocalDateTime.now())).build());
	}

	@PutMapping(value = "comment/{commentId}")
	public ResponseEntity<CommentDto> updateComment(@Valid @RequestBody CommentDto commentDto,
			@PathVariable Integer commentId) {
		CommentDto updatedComment = commentService.updateComment(commentDto, commentId);
		return new ResponseEntity<CommentDto>(updatedComment, HttpStatus.OK);
	}

	@GetMapping(value = "comment/{commentId}")
	public ResponseEntity<CommentDto> getCommentById(@PathVariable Integer commentId) {
		return new ResponseEntity<CommentDto>(commentService.getCommentById(commentId), HttpStatus.OK);
	}

	@GetMapping(value = "user/{userId}/comments")
	public ResponseEntity<List<CommentDto>> getCommentsByUser(@PathVariable Integer userId) {
		return new ResponseEntity<List<CommentDto>>(commentService.getCommentByUser(userId), HttpStatus.OK);
	}

	@GetMapping(value = "post/{postId}/comments")
	public ResponseEntity<List<CommentDto>> getCommentsByPost(@PathVariable Integer postId) {
		return new ResponseEntity<List<CommentDto>>(commentService.getCommentByPost(postId), HttpStatus.OK);
	}

	@GetMapping(value = "/comments")
	public ResponseEntity<PaginationResponse> getAllComments(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "3", required = false) Integer pageSize) {
		return new ResponseEntity<PaginationResponse>(commentService.getAllComments(pageNumber, pageSize),
				HttpStatus.OK);
	}
}
