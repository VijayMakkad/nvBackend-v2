package com.nightvigilance.nvBackend.repository;

import com.nightvigilance.nvBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
        User findByUserMail(String userMail);
}