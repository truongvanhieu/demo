package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/getallstudents")
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Nguyễn Văn A", "a1@gmail.com"));
        list.add(new Student(2, "Trần Thị B", "b2@gmail.com"));
        list.add(new Student(3, "Lê Văn C", "c3@gmail.com"));
        return list;
    }
}
