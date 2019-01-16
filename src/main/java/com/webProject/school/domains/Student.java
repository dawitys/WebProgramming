package com.webProject.school.domains;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import com.webProject.school.domains.Subject;

@Data
@Entity
 @NoArgsConstructor(access=AccessLevel.PUBLIC, force=true)
@RequiredArgsConstructor
public class Student {
	
//    protected Student() {}

//	public Student(String firstName, String lastName) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Date addedOn;
	
	@NotNull
	@Size(min=2, message="First Name must be at least 2 characters long")
	private final String firstName;
	
	@NotNull
	@Size(min=2, message="Last Name must be at least 2 characters long")
	private final String lastName;
	
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//	
	private int Age;
	
	private String identity;
	
	private String password;
	
//	
//	@ManyToMany(targetEntity=ClassRoom.class)
//	private ClassRoom classRoom;
//	
//	@ManyToMany(targetEntity=Subject.class)
//	private List<Subject> subjectsTaken;
	
//	private Map<Subject, Integer> Grades = new HashMap<>();
//	
//	public void setGrades(Subject subject, int Grade) {
//		this.Grades.put(subject, Grade);
//	}
//	
//	public int getGrades(Subject subject) {
//		return this.Grades.get(subject);
//	}
//	
//	public Map getGrades() {
//		return this.Grades;
//	}
	
	@PrePersist
	void addedOn() {
	    this.addedOn = new Date();
	  }
	
	@PostPersist
	void identity() {
	    this.identity = "STU" + "/" + this.id.toString() + "/" + addedOn.toString();
	  }
}
