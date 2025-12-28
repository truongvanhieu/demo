package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String hello()
	{
		return "Hello Spring Boot";
	}

	@GetMapping("/greet")
	public String greet(@RequestParam String name) {
		return "Hello " + name;
	}

	@GetMapping("/student/{id}")
	public int getStudent(@PathVariable int id) {
		int studentId = id;
		return studentId;
	}
}
