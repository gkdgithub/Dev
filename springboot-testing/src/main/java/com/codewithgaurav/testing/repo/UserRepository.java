package com.codewithgaurav.testing.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithgaurav.testing.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> findByAddress(String address);
	
	User findByEmail(String email);
}
