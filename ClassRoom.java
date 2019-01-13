package schoolsystem.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class ClassRoom {
	private String id;
	private final GradeLevel gradeLevel;
	private final Section section;
	
	public static enum GradeLevel {
		G9, G10, G11, G12
	}
	
	public static enum Section {
		A, B, C, D, E
	}
	
	public void setId() 
	{
		this.id =  gradeLevel.toString() + section.toString();
	}
	
}
