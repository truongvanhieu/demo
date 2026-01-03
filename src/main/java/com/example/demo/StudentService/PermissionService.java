package com.example.demo.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Permission;
import com.example.demo.repository.PermissionRepository;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepo;

    /**
     * Tạo permission mới
     */
    public Permission create(Permission permission) {
        return permissionRepo.save(permission);
    }

    /**
     * Lấy danh sách permission
     */
    public List<Permission> findAll() {
        return permissionRepo.findAll();
    }

    /**
     * Tìm permission theo id
     */
    public Permission findById(Long id) {
        return permissionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Permission not found"));
    }

    /**
     * Xóa permission
     */
    public void delete(Long id) {
        permissionRepo.deleteById(id);
    }
}