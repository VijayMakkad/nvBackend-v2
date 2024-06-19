package com.nightvigilance.nvBackend.controller;

import com.nightvigilance.nvBackend.model.Desig;
import com.nightvigilance.nvBackend.service.DesigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desig")
public class DesigController {
    @Autowired
    private DesigService desigService;

    @GetMapping
    public List<Desig> getAllDesigs() {
        return desigService.getAllDesigs();
    }

    @GetMapping("/{id}")
    public Desig getDesigById(@PathVariable int id) {
        return desigService.getDesigById(id);
    }

    @PostMapping
    public Desig saveDesig(@RequestBody Desig desig) {
        return desigService.saveDesig(desig);
    }

    @DeleteMapping("/{id}")
    public void deleteDesig(@PathVariable int id) {
        desigService.deleteDesig(id);
}
}
