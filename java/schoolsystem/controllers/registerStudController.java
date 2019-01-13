package schoolsystem.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import schoolsystem.domain.*;
import schoolsystem.repository.JdbcStudentRepository;
@Controller
@RequestMapping("/registerStud")
public class registerStudController {
	  @GetMapping
	  public String showDesignForm(Model model) {
	    return "registerStud";
	  }
	  
	  private JdbcStudentRepository studRepo;
	  
	  @Autowired
	  public registerStudController(JdbcStudentRepository studRepo) {
		  this.studRepo = studRepo;
	  }
	  
	  @PostMapping
	  public String processDesign(Student student) {
		  Student save = studRepo.save(student);
		  return "design";
	  }
	  
}
