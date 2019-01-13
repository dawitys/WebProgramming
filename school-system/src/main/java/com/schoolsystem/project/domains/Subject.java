package com.schoolsystem.project.domains;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class Subject {
	private Long id;
	private final GradeLevel level;
	private final SubjectType subject;
	private final String identity;

	public String setIdentity() {
		return subject.toString() + level.toString();
	}
}
