package com.webProject.school.services;

import java.util.Optional;
import com.webProject.school.domains.Student;

public interface StudentService {

	public Student save(Student students);
	
	public Iterable<Student> saveAll(Iterable<Student> students);

	Optional<Student> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Student> findAll();

	Iterable<Student> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(Student student);
	
	void deleteAll(Iterable<Student> students);

	void deleteAll();
}
