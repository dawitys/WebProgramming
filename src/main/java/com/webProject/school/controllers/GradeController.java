
package com.webProject.school.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.webProject.school.domains.News;
import com.webProject.school.domains.Student;
import com.webProject.school.domains.SubjectRegistration;
import com.webProject.school.repositories.StudentRepository;
import com.webProject.school.repositories.SubjectRegistrationRepository;
import com.webProject.school.security.User;
import com.webProject.school.services.NewsService;
import com.webProject.school.services.StudentService;
import com.webProject.school.services.SubjectRegistrationService;
import com.webProject.school.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/grades")
public class GradeController {

	private SubjectRegistrationService srp;
	

	@ModelAttribute(name="subs")
	public SubjectRegistration subs() {
		return new SubjectRegistration();
	}
	
	@ModelAttribute
	public void addNews(Model model) {
		ArrayList<SubjectRegistration> subjs = new ArrayList<>();
		ArrayList<Student> stids=new ArrayList<Student>();
		srp.findAllBysubject_id(1)
							.forEach(i->subjs.add(i));
		srp.findAllBysubject_id(1)
							.forEach(sb->stids.add(sb.getStudent()));
			model.addAttribute("allSub", subjs);
			model.addAttribute("allStuds", stids);
	}
	
	@GetMapping("/allNews")
	public String allNews() {
		return "grades_view";
	}
	
	@GetMapping("/allGrades")
	public String allGrades() {
		return "postResults";
	}
	
	@GetMapping("/current")
	public String newsForm() {
		return "news_form";
	}
}
