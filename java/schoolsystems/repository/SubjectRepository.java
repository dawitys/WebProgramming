package schoolsystems.repository;

import schoolsystem.domain.ClassRoom;
import schoolsystem.domain.GradeLevel;
import schoolsystem.domain.Student;
import schoolsystem.domain.Subject;
import schoolsystem.domain.Teacher;

public interface SubjectRepository {
	Iterable<Subject> findAll();

	Iterable<Subject> findByGradeLevel(GradeLevel gradelevel);

	Subject findByIdentity(String identity);

//	Subject save(Subject subject);
	
	Iterable<Subject> findByClassRoom(ClassRoom classroom);
	
	Iterable<Subject> findByTeacher(Teacher teacher);
	
	Iterable<Subject> findByStudent(Student student);
}
