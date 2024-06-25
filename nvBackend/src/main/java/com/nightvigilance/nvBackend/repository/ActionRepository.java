package com.nightvigilance.nvBackend.repository;

import com.nightvigilance.nvBackend.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer> {
}
