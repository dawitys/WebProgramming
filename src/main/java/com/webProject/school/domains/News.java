package com.webProject.school.domains;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import com.webProject.school.security.User;

import lombok.Data;

@Data
@Entity
@Table(name="news")
public class News {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date postedAt;
	
	@PrePersist
	void placedAt() {
		this.postedAt = new Date();
	}	
	
	public News() {
	}

	@Column(name = "title")
    @NotBlank(message = "Please provide Title")
    private String title;
    
    @Column(name = "Content")
    @NotBlank(message = "Content can not be empty")
    private String content;
    	
    @NotBlank(message = "Content can not be empty")
    private String catagory;
    
	@ManyToOne
	private  User postedBy;

}

