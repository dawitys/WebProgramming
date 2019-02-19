package com.webProject.school.services;

import java.util.Optional;
import com.webProject.school.domains.Subject;

public interface SubjectService {

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
