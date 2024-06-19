package com.nightvigilance.nvBackend.controller;

import com.nightvigilance.nvBackend.model.Img;
import com.nightvigilance.nvBackend.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/img")
public class ImgController {
    @Autowired
    private ImgService imgService;

    @GetMapping
    public List<Img> getAllImgs() {
        return imgService.getAllImgs();
    }

    @GetMapping("/{id}")
    public Img getImgById(@PathVariable int id) {
        return imgService.getImgById(id);
    }

    @PostMapping
    public Img saveImg(@RequestBody Img img) {
        return imgService.saveImg(img);
    }

    @DeleteMapping("/{id}")
    public void deleteImg(@PathVariable int id) {
        imgService.deleteImg(id);
}
}
