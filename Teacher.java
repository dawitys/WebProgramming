package schoolsystem.domain;

import java.util.List;

import lombok.Data;

@Data
public class Teacher {
	private int id;
	private String FirstName;
	private String LastName;
	private int Age;
	private List<Subject> teachingSubjects;
	private List<ClassRoom> classRooms;
}
