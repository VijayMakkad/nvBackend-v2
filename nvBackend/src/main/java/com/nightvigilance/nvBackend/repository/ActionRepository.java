package com.nightvigilance.nvBackend.repository;

import com.nightvigilance.nvBackend.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action,Integer>{
        }