package com.webProject.school.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller        
public class HomeController {
  
  @GetMapping("/")
  public String home() {
	 // throw new RuntimeException("Test Exception");
    return "home";    
  }
  
  @GetMapping("/test")
  public String test() {
	 // throw new RuntimeException("Test Exception");
    return "postNews";    
  }
  
  
  @GetMapping("/testsec")
  public String testSec() {
    return "testsec";    
  }

}
