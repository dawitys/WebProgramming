package com.webProject.school.domains;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity

public class ClassRoom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Date addedOn;

	private final GradeLevel gradeLevel;
	private final Section section;	
	private String Identity;

	@PrePersist
	void addedOn() {
	    this.addedOn = new Date();
	  }
	
	@PostPersist
	void identity() {
	    this.Identity = this.gradeLevel.toString() + this.section.toString();
	  }
}
