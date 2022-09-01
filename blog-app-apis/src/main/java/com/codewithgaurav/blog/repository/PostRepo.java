package com.codewithgaurav.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithgaurav.blog.entities.Category;
import com.codewithgaurav.blog.entities.Post;
import com.codewithgaurav.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	// we can create custom method based on pojo property

	// For a single user it will find multiple Post in database
	// select * from Post where user_id = user.id;
	List<Post> findByUser(User user);

	// In one category there are multiple post.
	List<Post> findByCategory(Category category);

	List<Post> findByTitleContainingIgnoreCase(String keyword);

	List<Post> findByContentContainingIgnoreCase(String keyword);

}
