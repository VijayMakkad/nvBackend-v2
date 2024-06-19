package com.nightvigilance.nvBackend.service;

import com.nightvigilance.nvBackend.model.LOC;
import com.nightvigilance.nvBackend.repository.LOCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LOCService {
    @Autowired
    private LOCRepository locRepository;

    public List<LOC> getAllLocations() {
        return locRepository.findAll();
    }

    public LOC getLocationById(int id) {
        return locRepository.findById(id).orElse(null);
    }

    public LOC saveLocation(LOC loc) {
        return locRepository.save(loc);
    }

    public void deleteLocation(int id) {
        locRepository.deleteById(id);
}
}
