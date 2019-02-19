package com.webProject.school.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.webProject.school.security.User;

public interface UserService extends UserDetailsService {

	User findUserByUsername(String username);
	void saveStudentUser(User user);
	void saveTeacherUser(User user);
	
}
