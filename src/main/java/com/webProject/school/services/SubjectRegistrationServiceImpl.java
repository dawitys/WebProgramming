package com.webProject.school.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webProject.school.domains.Subject;
import com.webProject.school.domains.SubjectRegistration;
import com.webProject.school.repositories.SubjectRegistrationRepository;

@Service
public class SubjectRegistrationServiceImpl implements SubjectRegistrationService {
	SubjectRegistrationRepository subjectRegistrationRepository;

	@Autowired
	public SubjectRegistrationServiceImpl(SubjectRegistrationRepository subjectRegistrationRepository) {
		this.subjectRegistrationRepository = subjectRegistrationRepository;
	}
	
	public SubjectRegistration save(SubjectRegistration sub) {
		return subjectRegistrationRepository.save(sub);
	}
	
	public Iterable<SubjectRegistration> saveAll(Iterable<SubjectRegistration> subs){
		return subjectRegistrationRepository.saveAll(subs);
	}

	public Optional<SubjectRegistration> findById(Long id){
		return subjectRegistrationRepository.findById(id);
	}

	public boolean existsById(Long id){
		return subjectRegistrationRepository.existsById(id);
	}
	
	public Iterable<SubjectRegistration> findAll(){
		return subjectRegistrationRepository.findAll();
	}

	public Iterable<SubjectRegistration> findAllById(Iterable<Long> ids){
		return subjectRegistrationRepository.findAllById(ids);
	}
	
	public Iterable<SubjectRegistration> findAllBysubject_id(long id){
		return subjectRegistrationRepository.findAllBysubject_id(id);
	}

	public long count() {
		return subjectRegistrationRepository.count();
	}
	
	public void deleteById(Long id) {
		subjectRegistrationRepository.deleteById(id);
	}
	
	public void delete(SubjectRegistration sub) {
		subjectRegistrationRepository.delete(sub);
	}
	
	public void deleteAll(Iterable<SubjectRegistration> sub){
		subjectRegistrationRepository.deleteAll(sub);
	}

	public void deleteAll(){
		subjectRegistrationRepository.deleteAll();
	}

	@Override
	public Iterable<SubjectRegistration> findAllBystudent_id(long id) {
		return subjectRegistrationRepository.findAllBystudent_id(id);
	}
}
