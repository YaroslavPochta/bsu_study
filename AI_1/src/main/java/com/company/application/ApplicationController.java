package com.company.application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
