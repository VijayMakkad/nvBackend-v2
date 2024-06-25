package com.nightvigilance.nvBackend.repository;

import com.nightvigilance.nvBackend.model.Img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImgRepository extends JpaRepository<Img, Integer> {
    List<Img> findByActionIdAndDeleteFlagFalse(int actionId);
}
