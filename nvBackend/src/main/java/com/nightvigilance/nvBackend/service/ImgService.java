package com.nightvigilance.nvBackend.service;

import com.nightvigilance.nvBackend.model.Img;
import com.nightvigilance.nvBackend.repository.ImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return imgRepository.save(img);
    }

    public void deleteImg(int id) {
        imgRepository.deleteById(id);
}
}