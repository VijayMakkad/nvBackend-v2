package com.nightvigilance.nvBackend.repository;

import com.nightvigilance.nvBackend.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersRepository extends JpaRepository<Members, Integer> {
}
