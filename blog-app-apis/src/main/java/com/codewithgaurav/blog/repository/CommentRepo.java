package com.codewithgaurav.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithgaurav.blog.entities.Comment;
import com.codewithgaurav.blog.entities.Post;
import com.codewithgaurav.blog.entities.User;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

	// In one post there are multiple Comment.
	List<Comment> findByPost(Post post);

	// For a single user there will be multiple Comment in database
	List<Comment> findByUser(User user);
}
