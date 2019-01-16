
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
import com.webProject.school.security.User;
import com.webProject.school.services.NewsService;
import com.webProject.school.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/newss")

public class NewsController {

	private NewsService newsService;
	private UserService userService;

	@Autowired
	public NewsController(NewsService newsService, UserService userService) {
		this.newsService = newsService;
		this.userService = userService;
	}
	@ModelAttribute(name="news")
	public News news() {
		return new News();
	}
	
	@ModelAttribute
	public void addNews(Model model) {
		List<News> news = new ArrayList<>();
		newsService.findAll()
							.forEach(i->news.add(i));
		
			model.addAttribute("allNews", news);
	}
	
	@GetMapping("/allNews")
	public String allNews() {
		return "news_view";
	}
	
	@GetMapping("/current")
	public String newsForm() {
		return "news_form";
	}

	@PostMapping
	public String processNews(@Valid News news, Errors errors, 
			SessionStatus sessionStatus, @AuthenticationPrincipal User user) {

		if (errors.hasErrors()) {
			return "news_form";
		}
		
		news.setPostedBy(user);
		
		News savedNews = newsService.save(news);
		log.info("News submitted: " + savedNews);
		sessionStatus.setComplete();
		return "redirect:/";
	}

}
