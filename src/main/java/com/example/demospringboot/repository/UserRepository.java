package com.example.demospringboot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demospringboot.models.auth.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	User findByUsername(String username);
}
