package schoolsystem.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import schoolsystem.domain.ClassRoom;
import schoolsystem.domain.GradeLevel;
import schoolsystem.domain.Student;
import schoolsystem.domain.Subject;
import schoolsystem.domain.Teacher;

public class JdbcSubjectRepository implements SubjectRepository {

	private JdbcTemplate jdbc;

	@Autowired
	public JdbcSubjectRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public Iterable<Subject> findAll() {
		return jdbc.query("select id, gradeLevel, subjectType from Course", this::mapRowToSubject);
	}

	@Override
	public Iterable<Subject> findByGradeLevel(GradeLevel gradelevel) {
		return jdbc.query("select id, gradeLevel, subjectType from Course where gradelevel=?", this::mapRowToSubject,
				gradelevel.toString());
	}

	private Subject mapRowToSubject(ResultSet rs, int rowNum) throws SQLException {
		return new Subject(null, null, null);
	}
}
