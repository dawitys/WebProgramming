package schoolsystems.repository;

import schoolsystem.domain.ClassRoom;
import schoolsystem.domain.GradeLevel;
import schoolsystem.domain.Student;
import schoolsystem.domain.Subject;
import schoolsystem.domain.Teacher;

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
