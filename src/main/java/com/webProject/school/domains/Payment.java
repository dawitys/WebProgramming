package com.webProject.school.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date paymentDate;
	
	@ManyToOne
	@JoinColumn(name ="student_id")
	private Student student;
	
	@NotNull
	@Size(min=10,message="reason should be at least 10 character long")
	private String reasonForPayment;
	
	@NotNull
	@Size(min=1,max=50000,message="Payment amount should be between 1 and 500000")
	private double amount;
	
	@PrePersist
	void placedAt() {
		this.paymentDate = new Date();
	}	
}
