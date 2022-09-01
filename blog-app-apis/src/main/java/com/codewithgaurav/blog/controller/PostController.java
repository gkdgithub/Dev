package com.codewithgaurav.blog.controller;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.codewithgaurav.blog.dto.PostDto;
import com.codewithgaurav.blog.response.ApiResponse;
import com.codewithgaurav.blog.response.PostPaginationResponse;
import com.codewithgaurav.blog.service.FileService;
import com.codewithgaurav.blog.service.PostService;

@RestController
@RequestMapping("api/")
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private FileService fileService;

	@PostMapping(value = "user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {
		return new ResponseEntity<PostDto>(this.postService.createPost(postDto, userId, categoryId),
				HttpStatus.CREATED);
	}

	@GetMapping("user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId) {
		return new ResponseEntity<List<PostDto>>(postService.getPostByUser(userId), HttpStatus.OK);
	}

	@GetMapping("category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId) {
		return new ResponseEntity<List<PostDto>>(postService.getPostByCategory(categoryId), HttpStatus.OK);
	}

	@GetMapping("/posts")
	public ResponseEntity<PostPaginationResponse> getAllPost(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {
		return new ResponseEntity<PostPaginationResponse>(postService.getAllPost(pageNumber, pageSize, sortBy, sortDir),
				HttpStatus.OK);
	}

	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {
		return new ResponseEntity<PostDto>(postService.getPostById(postId), HttpStatus.OK);
	}

	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable Integer postId) {
		return new ResponseEntity<PostDto>(postService.updatePost(postDto, postId), HttpStatus.OK);
	}

	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId) {
		postService.deletePost(postId);
		return ResponseEntity.ok(ApiResponse.builder().message("Post Deleted Successfully").success(true)
				.status(String.valueOf(HttpStatus.OK)).timeStamp(String.valueOf(LocalDateTime.now())).build());
	}

	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPosts(@PathVariable String keyword, @RequestParam String searchOn) {
		return new ResponseEntity<List<PostDto>>(postService.searchPosts(keyword, searchOn), HttpStatus.OK);
	}

	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<?> uploadPostImage(@PathVariable Integer postId,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {
		if (multipartFile.isEmpty()) {
			return ResponseEntity.status(500).body("Request must contains file");
		}
		PostDto postDto = postService.getPostById(postId);
		postDto.setImageName(fileService.uploadImage(multipartFile));
		return new ResponseEntity<PostDto>(postService.updatePost(postDto, postId), HttpStatus.OK);
	}

	// Serve image with HttpServletResponse
	@GetMapping(value = "/post/image/{imageName}", produces = MediaType.ALL_VALUE)
	public void downloadImage(@PathVariable String imageName, HttpServletResponse response) throws IOException {
		InputStream inputStream = fileService.getResource(imageName);
		response.setContentType(MediaType.ALL_VALUE);
		StreamUtils.copy(inputStream, response.getOutputStream());
	}

	// Serve image with ResponseEntity
//	@GetMapping(value = "/post/image/{imageName}", produces = MediaType.ALL_VALUE)
//	public ResponseEntity<byte[]> downloadImage(@PathVariable String imageName) throws IOException {
//		InputStream inputStream = fileService.getResource(imageName);
//		byte[] bytes = StreamUtils.copyToByteArray(inputStream);
//		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
//	}

}
