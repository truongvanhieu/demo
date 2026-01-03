package com.example.demo.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    // @Autowired
    // private PasswordEncoder encoder;

    public User createUser(String username, String password) {
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.setStatus("ACTIVE");
        
        return userRepo.save(u);
    }

    public User assignRole(Long userId, Long roleId) {
        User u = userRepo.findById(userId).orElseThrow();
        Role r = roleRepo.findById(roleId).orElseThrow();
        u.getRoles().add(r);
        return userRepo.save(u);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }
}

