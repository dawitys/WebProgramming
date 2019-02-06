package com.webProject.school.repositories;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import com.webProject.school.domains.Student;
import com.webProject.school.domains.*;//SubjectRegistration;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
	ArrayList<Student> getAllByRegistrations(Subject sub);
}
