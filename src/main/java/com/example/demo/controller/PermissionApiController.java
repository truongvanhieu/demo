package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Permission;
import com.example.demo.repository.PermissionRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/permissions")
public class PermissionApiController {

    @Autowired
    private PermissionRepository repo;

    @PostMapping
    public Permission create(@RequestBody Permission p) {
        return repo.save(p);
    }

    @GetMapping
    public List<Permission> list() {
        return repo.findAll();
    }
}