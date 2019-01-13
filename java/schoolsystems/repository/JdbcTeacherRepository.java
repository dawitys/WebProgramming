package schoolsystems.repository;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import schoolsystem.domain.ClassRoom;
import schoolsystem.domain.Student;
import schoolsystem.domain.Subject;
import schoolsystem.domain.Teacher;

public class JdbcTeacherRepository implements TeacherRepository {

	@Override
	public Iterable<Teacher> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Teacher> findByClass(ClassRoom classRoom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher save(Teacher teacher) {
//		long teacherId = saveTeacherInfo(teacher);
//		teacher.setId(teacherId);
//		saveClassRoomToStudent(student.getClassRoom(), studentId);
//		for (Subject subject : teacher.getTeaching()) {
//			saveSubjectToStudent(subject, studentId);
//		}
//		return student;
		return null;
	}

	@Override
	public Iterable<Teacher> findByCourse(Subject subject) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	private long saveTeacherInfo(Teacher teacher) {
//		teacher.setAddedOn(new Date());
//		PreparedStatementCreator psc = new PreparedStatementCreatorFactory(
//				"insert into Student (FirstName, LastName, Age, createdAt) values (?, ?, ?, ?)", Types.VARCHAR,
//				Types.VARCHAR, Types.SMALLINT, Types.TIMESTAMP)
//						.newPreparedStatementCreator(Arrays.asList(student.getFirstName(), student	.getLastName(),
//								student.getAge(), new Timestamp(student.getAddedOn().getTime())));
//
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//		jdbc.update(psc, keyHolder);
//
//		return keyHolder.getKey().longValue();
//	}
//
//	private void saveSubjectToStudent(Subject subject, long studentId) {
//		jdbc.update("insert into Student_Courses (student, course) " + "values (?, ?)", studentId, subject.getId());
//	}
//
//	private void saveClassRoomToStudent(ClassRoom classroom, long studentId) {
//		jdbc.update("insert into Student_Classes (student, classroom) " + "values (?, ?)", studentId, classroom.getId());
//	}

}
