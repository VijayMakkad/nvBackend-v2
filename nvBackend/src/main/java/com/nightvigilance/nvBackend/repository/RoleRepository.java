package com.nightvigilance.nvBackend.repository;

import com.nightvigilance.nvBackend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer>{
        }