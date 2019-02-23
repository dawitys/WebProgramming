
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

import com.webProject.school.domains.Attendance;
import com.webProject.school.security.User;
import com.webProject.school.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/attendance")
public class AttendanceController {

	private UserService userService;

	@Autowired
	public AttendanceController(UserService userService) {
		this.userService = userService;
	}
	
	@ModelAttribute(name="attendance")
	public Attendance attendance() {
		return new Attendance();
	}
	
	
	@GetMapping("/all")
	public String allAttendance() {
		return "attendance_view";
	}
	
	@GetMapping("/current")
	public String attendanceForm() {
		return "attendance_form";
	}

	@PostMapping
	public String processAttendance(@Valid Attendance att, Errors errors, 
			SessionStatus sessionStatus, @AuthenticationPrincipal User user) {

		if (errors.hasErrors()) {

			log.info("Attendance error: " + errors.toString());
			return "attendance_form";
		}

		log.info("Attendance submitted: " + att);
		sessionStatus.setComplete();
		return "redirect:/";
	}

}
