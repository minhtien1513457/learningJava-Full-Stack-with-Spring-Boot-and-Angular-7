package com.demo.todos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class WelcomeController {
	@GetMapping("/hello")
	public String hello () {
		return "hello";
	}
}
