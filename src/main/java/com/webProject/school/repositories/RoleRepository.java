package com.webProject.school.repositories;

import org.springframework.data.repository.CrudRepository;

import com.webProject.school.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

	 Role findByRole(String role);
	 
}
