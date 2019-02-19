package com.webProject.school.repositories;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.webProject.school.domains.*;

public interface SubjectRegistrationRepository extends CrudRepository< SubjectRegistration, Long >{
	
	Iterable<SubjectRegistration> findAllBystudent_id(long id);
	Iterable<SubjectRegistration> findAllBysubject_id(long id);
	
	//@Query("SELECT sr from subject_registration sr where subject_id =(SELECT su.id from subject su WHERE su.tought_by_id=?1)")
	//ArrayList<SubjectRegistration> findAllByTeacherId(long id);
	
	
}
