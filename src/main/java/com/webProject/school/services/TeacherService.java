package com.webProject.school.services;

import java.util.Optional;

import com.webProject.school.domains.News;
import com.webProject.school.domains.Teacher;

public interface TeacherService {

	public Teacher save(Teacher teachers);
	
	public Iterable<Teacher> saveAll(Iterable<Teacher> teachers);

	Optional<Teacher> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Teacher> findAll();

	Iterable<Teacher> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(Teacher teacher);
	
	void deleteAll(Iterable<Teacher> teachers);

	void deleteAll();
}
