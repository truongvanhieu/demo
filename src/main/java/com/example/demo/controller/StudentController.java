package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;

@RestController
@RequestMapping("/api")
public class StudentController {
    @GetMapping("/student")
    public Student getStudent() {
        return new Student(0, "Nguyễn Văn A", "a1@gmail.com");
    }
}
