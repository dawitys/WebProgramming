package schoolsystem.repository;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import schoolsystem.domain.ClassRoom;
import schoolsystem.domain.Student;
import schoolsystem.domain.Subject;
import schoolsystem.domain.Teacher;

public class JdbcTeacherRepository implements TeacherRepository {

	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcTeacherRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
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
		long teacherId = saveTeacherInfo(teacher);
		teacher.setId(teacherId);
		insertMap(teacher.getTeaching(), teacherId);
		return teacher;
	}

    private void insertMap(Map mp, long teacherId) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            for (ClassRoom classroom  : (List<ClassRoom>) pair.getValue()) {
            	saveClassRoomAndSubjectToTeacher(classroom, (Subject) pair.getKey(), teacherId);
            }
            it.remove();
        }
    }
	
	@Override
	public Iterable<Teacher> findByCourse(Subject subject) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private long saveTeacherInfo(Teacher teacher) {
		teacher.setAddedOn(new Date());
		PreparedStatementCreator psc = new PreparedStatementCreatorFactory(
				"insert into Teacher (FirstName, LastName, Age, addedOn) values (?, ?, ?, ?)", Types.VARCHAR,
				Types.VARCHAR, Types.SMALLINT, Types.TIMESTAMP)
						.newPreparedStatementCreator(Arrays.asList(teacher.getFirstName(), teacher.getLastName(),
								teacher.getAge(), new Timestamp(teacher.getAddedOn().getTime())));

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbc.update(psc, keyHolder);

		return keyHolder.getKey().longValue();
	}

	private void saveClassRoomAndSubjectToTeacher(ClassRoom classroom, Subject subject, long teacherId) {
		jdbc.update("insert into Teacher_ClassesClassRooms (teacher, classRoom, course) " + "values (?, ?, ?)", teacherId, classroom.getId(), subject.getId());
	}

//	private void saveClassRoomToTeacher(ClassRoom classroom, long teacherId) {
//		jdbc.update("insert into Teacher_Classes (teacher, classroom) " + "values (?, ?)", teacherId, classroom.getId());
//	}

}
