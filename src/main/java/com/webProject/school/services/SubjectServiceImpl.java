package com.webProject.school.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webProject.school.domains.Subject;
import com.webProject.school.repositories.NewsRepository;
import com.webProject.school.repositories.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {
	SubjectRepository subjectRepository;

	@Autowired
	public SubjectServiceImpl(SubjectRepository subjectRepository) {
		this.subjectRepository = subjectRepository;
	}
	
	public Subject save(Subject Subject) {
		return subjectRepository.save(Subject);
	}
	
	public Iterable<Subject> saveAll(Iterable<Subject> Subjects){
		return subjectRepository.saveAll(Subjects);
	}

	public Optional<Subject> findById(Long id){
		return subjectRepository.findById(id);
	}

	public boolean existsById(Long id){
		return subjectRepository.existsById(id);
	}
	
	public Iterable<Subject> findAll(){
		return subjectRepository.findAll();
	}

	public Iterable<Subject> findAllById(Iterable<Long> ids){
		return subjectRepository.findAllById(ids);
	}

	public long count() {
		return subjectRepository.count();
	}
	
	public void deleteById(Long id) {
		subjectRepository.deleteById(id);
	}
	
	public void delete(Subject Subject) {
		subjectRepository.delete(Subject);
	}
	
	public void deleteAll(Iterable<Subject> Subjects){
		subjectRepository.deleteAll(Subjects);
	}

	public void deleteAll(){
		subjectRepository.deleteAll();
	}
}
