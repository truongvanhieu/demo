package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.StudentService.UserService;
import com.example.demo.model.User;

@RestController
@RequestMapping("/api/users")
public class UserApiController {

    @Autowired
    private UserService userService;

    // @PreAuthorize("hasAuthority('USER_MANAGE')")
    @PostMapping
    public User create(@RequestParam String username,
                       @RequestParam String password) {
        return userService.createUser(username, password);
    }

    // @PreAuthorize("hasAuthority('USER_MANAGE')")
    @PostMapping("/{userId}/roles/{roleId}")
    public User assignRole(@PathVariable Long userId,
                           @PathVariable Long roleId) {
        return userService.assignRole(userId, roleId);
    }

    // @PreAuthorize("hasAuthority('USER_MANAGE')")
    @GetMapping
    public List<User> list() {
        return userService.findAll();
    }
}