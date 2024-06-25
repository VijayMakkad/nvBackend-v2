package com.nightvigilance.nvBackend.service;

import com.nightvigilance.nvBackend.model.Img;
import com.nightvigilance.nvBackend.repository.ImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ImgService {
    @Autowired
    private ImgRepository imgRepository;

    public List<Img> getAllImgs() {
        return imgRepository.findAll();
    }

    public Img getImgById(int id) {
        return imgRepository.findById(id).orElse(null);
    }

    public Img saveImg(Img img) {
        // Set audit fields
        img.setCreatedOn(img.getCreatedOn() != null ? img.getCreatedOn() : LocalDateTime.now());
        img.setUpdatedOn(img.getUpdatedOn() != null ? img.getUpdatedOn() : LocalDateTime.now());
        img.setDeleteFlag(img.isDeleteFlag());
        return imgRepository.save(img);
    }

    public void deleteImg(int id) {
        Img img = imgRepository.findById(id).orElse(null);
        if (img != null) {
            img.setDeleteFlag(true);
            imgRepository.save(img);
        }
    }
}