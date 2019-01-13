package schoolsystem.repository;

import schoolsystem.domain.ClassRoom;
import schoolsystem.domain.GradeLevel;
import schoolsystem.domain.Student;
import schoolsystem.domain.Subject;
import schoolsystem.domain.Teacher;

public interface SubjectRepository {
	Iterable<Subject> findAll();

	Iterable<Subject> findByGradeLevel(GradeLevel gradelevel);

//	Subject findByIdentity(String identity);

//	Subject save(Subject subject);
	
//	Iterable<Subject> findBySubject(Subject subject);
	
}
