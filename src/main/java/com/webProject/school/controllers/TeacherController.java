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

import com.webProject.school.security.User;
import com.webProject.school.services.RoleService;
import com.webProject.school.services.UserService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@ModelAttribute(name="user")
	public User user() {
		return new User();
	}
	
	@GetMapping("/home")
	public String teacherHome() {
		return "postResults";
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
        	
            userService.saveTeacherUser(user);
            
            model.addAttribute("successMessage", "User has been registered successfully");
            
            return "teacher_registration";
        }
    }
}
