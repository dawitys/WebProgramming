package com.webProject.school.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webProject.school.domains.Student;
import com.webProject.school.domains.Teacher;
import com.webProject.school.repositories.StudentRepository;
import com.webProject.school.security.User;
import com.webProject.school.services.RoleService;
import com.webProject.school.services.StudentService;
import com.webProject.school.services.UserService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/home")
	public String studentHome() {
		return "teacherHome";
	}
	@ModelAttribute(name="user")
	public User user() {
		return new User();
	}

    @GetMapping("/registration")
    public String registration(){
        return "student_registration";
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
            return "student_registration";
        } else {
            userService.saveStudentUser(user);
            User u = userService.findUserByUsername(user.getUsername());
            Student stud=new Student(user.getUsername());
            stud.setUser(u);
            studentService.save(stud);
            
            model.addAttribute("successMessage", "User has been registered successfully,You Can Login Now!");
            
            return "student_-registration";
        }
    }
    
}
