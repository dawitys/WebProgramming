package schoolsystem.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Student {
	private Long id;
	private Date addedOn;
	private final String FirstName;
	private final String LastName;
	private int Age;
	private String identity;
	private String password;
	private ClassRoom classRoom;
	private List<Subject> subjectsTaken;
	private Map<Subject, Integer> Grades = new HashMap<>();
	
	public void setGrades(Subject subject, int Grade) {
		this.Grades.put(subject, Grade);
	}
	
	public int getGrades(Subject subject) {
		return this.Grades.get(subject);
	}
	
	public Map getGrades() {
		return this.Grades;
	}
	public String setIdentity() {
		return "STU";
	}
//	private final String id;
}
