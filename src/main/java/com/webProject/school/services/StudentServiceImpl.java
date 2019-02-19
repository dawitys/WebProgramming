package com.webProject.school.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webProject.school.domains.Student;
import com.webProject.school.repositories.NewsRepository;
import com.webProject.school.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public Student save(Student student) {
		return studentRepository.save(student);
	}
	
	public Iterable<Student> saveAll(Iterable<Student> students){
		return studentRepository.saveAll(students);
	}

	public Optional<Student> findById(Long id){
		return studentRepository.findById(id);
	}

	public boolean existsById(Long id){
		return studentRepository.existsById(id);
	}
	
	public Iterable<Student> findAll(){
		return studentRepository.findAll();
	}

	public Iterable<Student> findAllById(Iterable<Long> ids){
		return studentRepository.findAllById(ids);
	}

	public long count() {
		return studentRepository.count();
	}
	
	public void deleteById(Long id) {
		studentRepository.deleteById(id);
	}
	
	public void delete(Student student) {
		studentRepository.delete(student);
	}
	
	public void deleteAll(Iterable<Student> students){
		studentRepository.deleteAll(students);
	}

	public void deleteAll(){
		studentRepository.deleteAll();
	}
}
