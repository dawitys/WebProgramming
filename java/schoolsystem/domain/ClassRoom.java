package schoolsystem.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class ClassRoom {
	private Long id;
	private final GradeLevel gradeLevel;
	private final Section section;	
	private String identity;

	public String setIdentity() {
		return this.gradeLevel.toString() + this.section.toString(); 
	}
}
