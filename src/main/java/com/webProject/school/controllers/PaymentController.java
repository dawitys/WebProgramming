
package com.webProject.school.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.webProject.school.domains.Payment;
import com.webProject.school.security.User;
import com.webProject.school.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/payments")
public class PaymentController {

	private UserService userService;
	
	@Autowired
	public PaymentController(UserService userService) {
		this.userService = userService;
	}

	@ModelAttribute(name="payment")
	public Payment payment() {
		return new Payment();
	}
	
	@ModelAttribute
	public void addPayment(Model model) {
		List<Payment> payments = new ArrayList<>();

			model.addAttribute("allPayments", payments);
	}
	
	@GetMapping("/all")
	public String allPayment() {
		return "payment_view";
	}
	
	@GetMapping("/new")
	public String paymentForm() {
		return "payment_form";
	}

	@PostMapping
	public String processPayment(@Valid Payment payment, Errors errors, 
			SessionStatus sessionStatus, @AuthenticationPrincipal User user) {

		if (errors.hasErrors()) {

			log.info("payment error: " + errors.toString());
			return "payment_form";
		}

		log.info("Payment submitted: " + payment);
		sessionStatus.setComplete();
		return "redirect:/";
	}

}
