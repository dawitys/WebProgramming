package com.schoolsystem.project.domains;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Teacher {
	private Long id;
	private Date addedOn;
	private final String FirstName;
	private final String LastName;
	private int Age;
	private final String identity;
	private Map<Subject, List<ClassRoom>> teaching = new HashMap<>();
	
	public void setMap(Subject subject, ClassRoom classroom) {
	    ArrayList<ClassRoom> rooms = new ArrayList<>(this.teaching.get(subject));
	    rooms.add(classroom);
		this.teaching.put(subject, rooms);
	}
	
	public String setIdentity() {
//		return "TEA" + this.FirstName[0] + this.LastName[0];
		return "TEA";
	}
}
