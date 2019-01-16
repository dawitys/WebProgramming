package com.webProject.school.repositories;

import org.springframework.data.repository.CrudRepository;

import com.webProject.school.security.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByUsername(String username);
	
}
