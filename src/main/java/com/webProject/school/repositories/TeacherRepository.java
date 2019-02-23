package com.webProject.school.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.webProject.school.domains.Teacher;
import com.webProject.school.domains.Subject;

public interface TeacherRepository extends CrudRepository<Teacher, Long>{
	
//	ArrayList<Teacher> getAllByRegistrations(Subject sub);
	Optional<Teacher> findByUserId(long id);
	  
	//@Query("SELECT t FROM teacher t WHERE id=(SELECT s.tought_by_id FROM subject s WHERE id =?1)")
	Teacher findBysubjectOfferings(long id);
}
