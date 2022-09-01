package com.codewithgaurav.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithgaurav.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
