package com.webProject.school.repositories;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import com.webProject.school.domains.Student;
import com.webProject.school.domains.*;//SubjectRegistration;

public interface SubjectRepository extends CrudRepository<Subject, Long>{
	Iterable<Subject> findAllByToughtBy(Teacher teacher);
	Subject findByIdentity(String iden);
}
