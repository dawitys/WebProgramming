package com.webProject.school.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class LoginController {
	
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
