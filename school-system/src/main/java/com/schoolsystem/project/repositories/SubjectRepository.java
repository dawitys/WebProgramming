package com.schoolsystem.project.repositories;

import com.schoolsystem.project.domains.ClassRoom;
import com.schoolsystem.project.domains.GradeLevel;
import com.schoolsystem.project.domains.Student;
import com.schoolsystem.project.domains.Subject;
import com.schoolsystem.project.domains.Teacher;

public interface SubjectRepository {
	Iterable<Subject> findAll();

	Iterable<Subject> findByGradeLevel(GradeLevel gradelevel);

	Subject findByIdentity(String identity);

//	Subject save(Subject subject);
	
	Iterable<Subject> findByClassRoom(ClassRoom classroom);
	
	Iterable<Subject> findByTeacher(Teacher teacher);
	
	Iterable<Subject> findByStudent(Student student);
}
