package com.schoolsystem.project.domains;

import java.util.Date;
import java.util.List;
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
	
	public String setIdentity() {
		return "STU";
	}
//	private final String id;
}
