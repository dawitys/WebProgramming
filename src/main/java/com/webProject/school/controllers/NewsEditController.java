
package com.webProject.school.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.webProject.school.domains.News;
import com.webProject.school.security.User;
import com.webProject.school.services.NewsService;
import com.webProject.school.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/newss/edit")

public class NewsEditController {

	private NewsService newsService;
	private UserService userService;

	@Autowired
	public NewsEditController(NewsService newsService, UserService userService) {
		this.newsService = newsService;
		this.userService = userService;
	}
	@ModelAttribute(name="news")
	public News newNews() {
		return new News();
	}
	
	@ModelAttribute
	public void findAllNews(Model model) {
		List<News> news = new ArrayList<>();
		newsService.findAll()
							.forEach(i->news.add(i));
		
			model.addAttribute("allNews", news);
	}

	@GetMapping
  	public Iterable<News> allNews() {
    	return newsService.findAll();
  	}
  
	@GetMapping("/{id}")
	public String byId(@PathVariable("id") Long id, Model model) {
		News n=newsService.findById(id).get();
		model.addAttribute("news", n);
		return "edit_news_form";
	}

	@PostMapping("/{id}")
	public String updateNews(@PathVariable("id") Long id,News news) {
		if (!news.getId().equals(id)) {
		 	throw new IllegalStateException("Given news's ID doesn't match the ID in the path.");
		}
		newsService.save(news);
		return "redirect:/newss/allNews";
	}

	@GetMapping("delete/{id}")
	public String deleteNews(@PathVariable("id") Long id) {
		newsService.deleteById(id);
		return "redirect:/newss/allNews";
	}
}
