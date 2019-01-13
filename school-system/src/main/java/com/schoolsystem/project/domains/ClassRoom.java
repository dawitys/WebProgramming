package com.schoolsystem.project.domains;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class ClassRoom {
	private Long id;
	private final GradeLevel gradeLevel;
	private final Section section;	
	private final String identity;

	public String setIdentity() {
		return this.gradeLevel.toString() + this.section.toString(); 
	}
}
