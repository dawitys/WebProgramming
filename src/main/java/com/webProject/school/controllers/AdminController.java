package com.webProject.school.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webProject.school.domains.Subject;
import com.webProject.school.domains.SubjectRegistration;
import com.webProject.school.domains.Teacher;
import com.webProject.school.security.User;
import com.webProject.school.services.RoleService;
import com.webProject.school.services.SubjectRegistrationService;
import com.webProject.school.services.SubjectService;
import com.webProject.school.services.TeacherService;
import com.webProject.school.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private SubjectRegistrationService registrationService;
	
	
	public AdminController(UserService us,RoleService rs,TeacherService ts,SubjectService ss,SubjectRegistrationService srs) {
		this.registrationService=srs;
		this.userService=us;
		this.subjectService=ss;
		this.teacherService=ts;
		this.roleService=rs;
	}
	/*
	@ModelAttribute("allTeachers")
	public Teacher[] getMultiCheckboxAllValues() {
		int c=(int) teacherService.count();
		Teacher[] teachers= new Teacher[c];	
		Iterable<Teacher> ts=teacherService.findAll();
		int i=0;
	    for (Teacher teacher : ts) {
			teachers[i]=teacher;
			i++;
		}
	    return teachers;
	}
	*/
	@GetMapping("/home")
	public String adminHome(Model model) {
		model.addAttribute("subject", new Subject());
		Iterable<Teacher> teachers=teacherService.findAll();

		Iterable<Subject> subjects=subjectService.findAll();
		model.addAttribute("allSub", subjects);
		model.addAttribute("teachers", teachers);
		return "subject_form";
	}
	@PostMapping("/addSubject")
	public String addSubject(@Valid Subject sub,Errors errors) {
		if (errors.hasErrors()) {
			return "subject_form";
		}
		log.info(errors.toString());
		log.info(sub.toString());
		subjectService.save(sub);
		return "redirect:/admin/home";
	}
}
