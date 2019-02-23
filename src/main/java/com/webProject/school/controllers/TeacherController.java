package com.webProject.school.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

@Controller
@RequestMapping("/teacher")
public class TeacherController {

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
	
	
	public TeacherController(UserService us,RoleService rs,TeacherService ts,SubjectService ss,SubjectRegistrationService srs) {
		this.registrationService=srs;
		this.userService=us;
		this.subjectService=ss;
		this.teacherService=ts;
		this.roleService=rs;
	}
	
	
	@ModelAttribute(name="user")
	public User user() {
		return new User();
	}
	
	@GetMapping("/home")
	public String teacherHome(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user=userService.findUserByUsername(auth.getName());
		Optional<Teacher> teacher = teacherService.findByUserId(user.getId());
        if (teacher.isPresent()) {
        	Teacher teac=teacher.get();
        	model.addAttribute("teacherUser",teac);
        
        	Iterable<Subject> sub = subjectService.findAllByToughtBy(teac);
        	model.addAttribute("offeredSubjects",sub);
        	for (Subject subject : sub) {
        		Iterable<SubjectRegistration> registrations = registrationService.findAllBysubject_id(subject.getId());
            	model.addAttribute(subject.getIdentity(),registrations);
			}      	        	
        }
        
		return "postResults";
	}
	@GetMapping("/subject/{subj}")
	public String teacherHome(@PathVariable("subj") String subj, Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user=userService.findUserByUsername(auth.getName());
		Optional<Teacher> teacher = teacherService.findByUserId(user.getId());
        if (teacher.isPresent()) {
        	Teacher teac=teacher.get();
        	model.addAttribute("teacherUser",teac);
        
        	Subject sub = subjectService.findByIdentity(subj);
        	model.addAttribute("offeredSubject",sub);
    		Iterable<SubjectRegistration> registrations = registrationService.findAllBysubject_id(sub.getId());
    		SubjectRegistration reg = registrationService.findById((long) 2).get();
    		model.addAttribute("re1",reg);
    		model.addAttribute("subjectRegistrations",registrations);
        	for (SubjectRegistration subjectRegistration : registrations) {
        		model.addAttribute("reg"+subjectRegistration.getId(),subjectRegistration);
			}
        }
        
		return "SubjectPostResults";
	}
	@PostMapping("/subject/update/{id}")
	public String updateGrade(@PathVariable("id") long id, SubjectRegistration su,Model model){
		SubjectRegistration f_sub=registrationService.findById(id).get();
		f_sub.setGrade(su.getGrade());
		registrationService.save(f_sub);
		model.addAttribute("success","successfuly updated grade");
        return "redirect:/teacher/home";
    }
	
	@GetMapping("/registration")
    public String registration(){
        return "teacher_registration";
    }

    @PostMapping("/registration")
    public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {
        User userExists = userService.findUserByUsername(user.getUsername());
        if (userExists != null) {
            bindingResult
                    .rejectValue("user", "error.user",
                            "There is already a user registered with the username provided");
        }
        if (bindingResult.hasErrors()) {
            return "teacher_registration";
        } else {
        	//teacherService.findByUserId(id)
            userService.saveTeacherUser(user);
            User u = userService.findUserByUsername(user.getUsername());
            Teacher teac=new Teacher(user.getUsername());
            teac.setUser(u);
            teacherService.save(teac);
            model.addAttribute("successMessage", "User has been registered successfully,You Can Login Now!");
            
            return "teacher_registration";
        }
    }
}
