package com.webProject.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
//@EnableAdminServer
public class StudentSystemApplication extends SpringBootServletInitializer {
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StudentSystemApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentSystemApplication.class, args);
	}
}
