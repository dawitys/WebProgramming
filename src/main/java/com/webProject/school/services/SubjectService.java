package com.webProject.school.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.webProject.school.domains.Subject;
import com.webProject.school.domains.Teacher;

public interface SubjectService {
	
	public Iterable<Subject> findAllByToughtBy(Teacher teacher);
	
	public Subject findByIdentity(String subject);
	
	public Subject save(Subject subjects);
	
	public Iterable<Subject> saveAll(Iterable<Subject> subjects);

	Optional<Subject> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Subject> findAll();

	Iterable<Subject> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(Subject subject);
	
	void deleteAll(Iterable<Subject> subjects);

	void deleteAll();
}
