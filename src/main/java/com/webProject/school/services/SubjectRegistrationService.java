package com.webProject.school.services;

import java.util.Optional;
import com.webProject.school.domains.SubjectRegistration;

public interface SubjectRegistrationService {

	public SubjectRegistration save(SubjectRegistration subjectRegistrations);
	
	public Iterable<SubjectRegistration> saveAll(Iterable<SubjectRegistration> subjectRegistrations);

	Optional<SubjectRegistration> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<SubjectRegistration> findAll();

	Iterable<SubjectRegistration> findAllById(Iterable<Long> ids);
	
	Iterable<SubjectRegistration> findAllBysubject_id(long id);

	long count();
	
	void deleteById(Long id);
	
	void delete(SubjectRegistration subjectRegistration);
	
	void deleteAll(Iterable<SubjectRegistration> subjects);

	void deleteAll();
}
