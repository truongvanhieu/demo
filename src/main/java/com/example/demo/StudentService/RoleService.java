package com.example.demo.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Permission;
import com.example.demo.model.Role;
import com.example.demo.repository.PermissionRepository;
import com.example.demo.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PermissionRepository permRepo;

    public Role createRole(Role role) {
        return roleRepo.save(role);
    }

    public Role addPermission(Long roleId, Long permId) {
        Role r = roleRepo.findById(roleId).orElseThrow();
        Permission p = permRepo.findById(permId).orElseThrow();
        r.getPermissions().add(p);
        return roleRepo.save(r);
    }
}