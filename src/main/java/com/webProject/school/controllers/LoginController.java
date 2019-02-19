package com.webProject.school.controllers;

import java.io.Console;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webProject.school.security.User;
import com.webProject.school.services.RoleService;
import com.webProject.school.services.UserService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class LoginController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
    @GetMapping("/login")    
    public String login(){
        return "login";
    }
    
    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access_denied";
    }
    @GetMapping("/defaultLogin")
    public String defaultAfterLogin(@AuthenticationPrincipal UserDetails userDetails) {
		log.info("default");
        String role = userDetails.getAuthorities().toString();
        String targetUrl = "";
        if (role.contains("ADMIN")) {
            targetUrl = "redirect:/admin/home";
        } else if (role.contains("STUDENT")) {
            targetUrl = "redirect:/student/home";
        } else if (role.contains("TEACHER")) {
            targetUrl = "redirect:/teacher/home";
        } else {
            targetUrl = "redirect:/access-denied";
        }
        return targetUrl;
        
		//return "home";
    }

}
