package schoolsystem.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class Subject {
	
	private String id;
	private final GradeLevel level;
	private final SubjectType subject;

	public void setId() 
	{
		this.id =  subject.toString() + level.toString();
	}
	
	public static enum GradeLevel {
		G9, G10, G11, G12
	}
	
	public static enum SubjectType {
		MATH, CHEMISTRY, PHYSICS, BIOLOGY, CIVICS, ENGLISH, AMHARIC, GEOGRAPHY, HISTORY, COMMUNICATION
	}

}
