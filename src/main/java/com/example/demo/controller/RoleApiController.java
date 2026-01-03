package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.StudentService.RoleService;
import com.example.demo.model.Role;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/roles")
public class RoleApiController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public Role create(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @PostMapping("/{roleId}/permissions/{permId}")
    public Role addPermission(@PathVariable Long roleId,
                              @PathVariable Long permId) {
        return roleService.addPermission(roleId, permId);
    }
}