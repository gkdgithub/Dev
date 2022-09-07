package com.codewithgaurav.blog.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codewithgaurav.blog.dto.PostDto;
import com.codewithgaurav.blog.entities.Category;
import com.codewithgaurav.blog.entities.Post;
import com.codewithgaurav.blog.entities.User;
import com.codewithgaurav.blog.exceptions.ResourceNotFoundException;
import com.codewithgaurav.blog.mapper.PostMapper;
import com.codewithgaurav.blog.repository.CategoryRepo;
import com.codewithgaurav.blog.repository.PostRepo;
import com.codewithgaurav.blog.repository.UserRepo;
import com.codewithgaurav.blog.response.PaginationResponse;
import com.codewithgaurav.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private PostMapper postMapper;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

		Category category = getCategoryById(categoryId);

		User user = getUserById(userId);

		Post post = postMapper.dtoToPost(postDto);
		post.setImageName("default.png");
		post.setAddedDate(String.valueOf(LocalDateTime.now()));
		post.setCategory(category);
		post.setUser(user);

		return postMapper.postToDto(postRepo.save(post));
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = getPostBasedOnId(postId);
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		if (postDto.getImageName() != null && postDto.getImageName().length() > 0)
			post.setImageName(postDto.getImageName());

		Post updatedPost = postRepo.save(post);
		return postMapper.postToDto(updatedPost);
	}

	@Override
	public PaginationResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

		Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		Page<Post> pages = postRepo.findAll(pageable);
		List<Post> posts = pages.getContent();

		List<PostDto> postDtos = posts.stream().map(post -> postMapper.postToDto(post)).collect(Collectors.toList());

		return PaginationResponse.builder().content(postDtos).pageNumber(pages.getNumber()).pageSize(pages.getSize())
				.totalElements(pages.getTotalElements()).totalPage(pages.getTotalPages()).lastPage(pages.isLast())
				.build();
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = getPostBasedOnId(postId);
		return postMapper.postToDto(post);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = getPostBasedOnId(postId);
		postRepo.delete(post);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {

		Category category = getCategoryById(categoryId);
		List<Post> posts = postRepo.findByCategory(category);
		return posts.stream().map(post -> postMapper.postToDto(post)).collect(Collectors.toList());
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {

		User user = getUserById(userId);
		return postRepo.findByUser(user).stream().map(singlePost -> postMapper.postToDto(singlePost))
				.collect(Collectors.toList());
	}

	@Override
	public List<PostDto> searchPosts(String keyword, String searchOn) {
		return (searchOn != null && searchOn.equalsIgnoreCase("title")) ? searchPostsByTitle(keyword)
				: searchPostsByContent(keyword);
	}

	public List<PostDto> searchPostsByTitle(String keyword) {
		return postRepo.findByTitleContainingIgnoreCase(keyword).stream().map((post) -> postMapper.postToDto(post))
				.collect(Collectors.toList());
	}

	public List<PostDto> searchPostsByContent(String keyword) {
		return postRepo.findByContentContainingIgnoreCase(keyword).stream().map((post) -> postMapper.postToDto(post))
				.collect(Collectors.toList());
	}

	private Category getCategoryById(Integer categoryId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found with this Id : " + categoryId));
		return category;
	}

	private User getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with this Id: " + userId));
		return user;
	}

	/**
	 * @param postId
	 * @return
	 */
	private Post getPostBasedOnId(Integer postId) {
		return postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post not found with this Id: " + postId));
	}

}
