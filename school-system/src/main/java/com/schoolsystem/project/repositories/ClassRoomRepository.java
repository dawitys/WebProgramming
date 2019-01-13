package com.schoolsystem.project.repositories;

import com.schoolsystem.project.domains.ClassRoom;
import com.schoolsystem.project.domains.GradeLevel;
import com.schoolsystem.project.domains.Student;
import com.schoolsystem.project.domains.Subject;
import com.schoolsystem.project.domains.Teacher;

public interface ClassRoomRepository {
	Iterable<ClassRoom> findAll();

	Iterable<ClassRoom> findByGradeLevel(GradeLevel gradelevel);

	ClassRoom findByIdentity(String identity);

//	ClassRoom save(ClassRoom classroom);
//	
	Iterable<ClassRoom> findByCourse(Subject subject);
	
	Iterable<ClassRoom> findByTeacher(Teacher teacher);
	
	ClassRoom findByStudent(Student student);
}
