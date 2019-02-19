package com.webProject.school.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webProject.school.domains.Teacher;
import com.webProject.school.repositories.NewsRepository;
import com.webProject.school.repositories.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {
	TeacherRepository teacherRepository;

	@Autowired
	public TeacherServiceImpl(TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}
	
	public Teacher save(Teacher Teacher) {
		return teacherRepository.save(Teacher);
	}
	
	public Iterable<Teacher> saveAll(Iterable<Teacher> Teachers){
		return teacherRepository.saveAll(Teachers);
	}

	public Optional<Teacher> findById(Long id){
		return teacherRepository.findById(id);
	}

	public boolean existsById(Long id){
		return teacherRepository.existsById(id);
	}
	
	public Iterable<Teacher> findAll(){
		return teacherRepository.findAll();
	}

	public Iterable<Teacher> findAllById(Iterable<Long> ids){
		return teacherRepository.findAllById(ids);
	}

	public long count() {
		return teacherRepository.count();
	}
	
	public void deleteById(Long id) {
		teacherRepository.deleteById(id);
	}
	
	public void delete(Teacher Teacher) {
		teacherRepository.delete(Teacher);
	}
	
	public void deleteAll(Iterable<Teacher> Teachers){
		teacherRepository.deleteAll(Teachers);
	}

	public void deleteAll(){
		teacherRepository.deleteAll();
	}
}
