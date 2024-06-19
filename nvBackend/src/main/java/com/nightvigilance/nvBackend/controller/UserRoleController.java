package com.nightvigilance.nvBackend.controller;

import com.nightvigilance.nvBackend.model.UserRole;
import com.nightvigilance.nvBackend.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userrole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @GetMapping
    public List<UserRole> getAllUserRoles() {
        return userRoleService.getAllUserRoles();
    }

    @GetMapping("/{id}")
    public UserRole getUserRoleById(@PathVariable int id) {
        return userRoleService.getUserRoleById(id);
    }

    @PostMapping
    public UserRole saveUserRole(@RequestBody UserRole userRole) {
        return userRoleService.saveUserRole(userRole);
    }

    @DeleteMapping("/{id}")
    public void deleteUserRole(@PathVariable int id) {
        userRoleService.deleteUserRole(id);
}
}
