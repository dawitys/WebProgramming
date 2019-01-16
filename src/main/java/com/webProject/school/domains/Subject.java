package com.webProject.school.domains;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity

public class Subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Date addedOn;

	@NotNull
	private final GradeLevel level;

	@NotNull
	private final SubjectType subject;
	
	private String Identity;
	
	private int Grade;
	
	@PrePersist
	void addedOn() {
	    this.addedOn = new Date();
	  }
	
//	@PostPersist
	void Identity() {
	    this.Identity = this.level.toString() + this.subject.toString();
	  }
}
