package com.webProject.school.domains;

import java.util.ArrayList;
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

@Data
@Entity
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
public class Teacher {
	
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
	
	private int Age;
	
	private String Identity;
	
	private String password;
	
//	@ManyToMany(targetEntity=ClassRoom.class)
//	private List<ClassRoom> classRoom;
//	
//	@ManyToMany(targetEntity=Subject.class)
//	private List<Subject> subjectsGiven;
	
//	private Map<Subject, List<ClassRoom>> teaching = new HashMap<>();
//	
//	public void setMap(Subject subject, ClassRoom classroom) {
//	    ArrayList<ClassRoom> rooms = new ArrayList<>(this.teaching.get(subject));
//	    rooms.add(classroom);
//		this.teaching.put(subject, rooms);
//	}
//	
//	public Map getMap() {
//		return this.teaching;
//	}
	
//	public List<ClassRoom> getMap(Subject subject, ClassRoom classroom){
//		return new ArrayList<>(this.teaching.get(subject));
//	}
	
	@PrePersist
	void addedOn() {
	    this.addedOn = new Date();
	  }
	
	@PostPersist
	void identity() {
	    this.Identity = "TEA" + "/" + this.id.toString() + "/" + addedOn.toString();
	  }
}
