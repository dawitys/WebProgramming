package schoolsystem.repository;

import schoolsystem.domain.*;

public interface StudentRepository {
	Iterable<Student> findAll();

	Iterable<Student> findByClass(ClassRoom classRoom);

	Student findById(String id);

	Student save(Student student);
	
	Iterable<Student> findByCourse(Subject subject);
	
	Iterable<Student> findByTeacher(Teacher teacher);

}
