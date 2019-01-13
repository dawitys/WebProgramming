package com.schoolsystem.project.repositories;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.schoolsystem.project.domains.ClassRoom;
import com.schoolsystem.project.domains.Student;
import com.schoolsystem.project.domains.Subject;
import com.schoolsystem.project.domains.Teacher;

@Repository

public class JdbcStudentRepository implements StudentRepository {

	private JdbcTemplate jdbc;

	public JdbcStudentRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public Iterable<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Student> findByClass(ClassRoom classRoom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student save(Student student) {
		long studentId = saveStudentInfo(student);
		student.setId(studentId);
		saveClassRoomToStudent(student.getClassRoom(), studentId);
		for (Subject subject : student.getSubjectsTaken()) {
			saveSubjectToStudent(subject, studentId);
		}
		return student;
	}

	private long saveStudentInfo(Student student) {
		student.setAddedOn(new Date());
		PreparedStatementCreator psc = new PreparedStatementCreatorFactory(
				"insert into Student (FirstName, LastName, Age, createdAt) values (?, ?, ?, ?)", Types.VARCHAR,
				Types.VARCHAR, Types.SMALLINT, Types.TIMESTAMP)
						.newPreparedStatementCreator(Arrays.asList(student.getFirstName(), student.getLastName(),
								student.getAge(), new Timestamp(student.getAddedOn().getTime())));

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbc.update(psc, keyHolder);

		return keyHolder.getKey().longValue();
	}

	private void saveSubjectToStudent(Subject subject, long studentId) {
		jdbc.update("insert into Student_Courses (student, course) " + "values (?, ?)", studentId, subject.getId());
	}

	private void saveClassRoomToStudent(ClassRoom classroom, long studentId) {
		jdbc.update("insert into Student_Classes (student, classroom) " + "values (?, ?)", studentId, classroom.getId());
	}
	
	@Override
	public Iterable<Student> findByCourse(Subject subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Student> findByTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return null;
	}

}
