package com.nightvigilance.nvBackend.repository;

import com.nightvigilance.nvBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{
        }
