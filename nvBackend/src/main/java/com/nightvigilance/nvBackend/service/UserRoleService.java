package com.nightvigilance.nvBackend.service;

import com.nightvigilance.nvBackend.model.UserRole;
import com.nightvigilance.nvBackend.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    public UserRole getUserRoleById(int id) {
        return userRoleRepository.findById(id).orElse(null);
    }

    public UserRole saveUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    public void deleteUserRole(int id) {
        userRoleRepository.deleteById(id);
}
}