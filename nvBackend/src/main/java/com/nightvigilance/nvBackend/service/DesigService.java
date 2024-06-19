package com.nightvigilance.nvBackend.service;

import com.nightvigilance.nvBackend.model.Desig;
import com.nightvigilance.nvBackend.repository.DesigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesigService {
    @Autowired
    private DesigRepository desigRepository;

    public List<Desig> getAllDesigs() {
        return desigRepository.findAll();
    }

    public Desig getDesigById(int id) {
        return desigRepository.findById(id).orElse(null);
    }

    public Desig saveDesig(Desig desig) {
        return desigRepository.save(desig);
    }

    public void deleteDesig(int id) {
        desigRepository.deleteById(id);
}
}
