package com.codewithgaurav.blog.service;

import java.util.List;

import com.codewithgaurav.blog.dto.PostDto;
import com.codewithgaurav.blog.response.PaginationResponse;

public interface PostService {

	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	PostDto updatePost(PostDto postDto, Integer postId);

	PaginationResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

	PostDto getPostById(Integer postId);

	void deletePost(Integer postId);

	// get all post by category
	List<PostDto> getPostByCategory(Integer categoryId);

	// get all post by user
	List<PostDto> getPostByUser(Integer userId);

	// search post
	List<PostDto> searchPosts(String keyword, String searchOn);

}
