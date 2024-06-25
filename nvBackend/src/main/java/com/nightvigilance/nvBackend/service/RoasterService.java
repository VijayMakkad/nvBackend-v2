package com.nightvigilance.nvBackend.service;

import com.nightvigilance.nvBackend.model.Roaster;
import com.nightvigilance.nvBackend.repository.RoasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoasterService {
    @Autowired
    private RoasterRepository roasterRepository;

    public List<Roaster> getAllRoasters() {
        return roasterRepository.findAll();
    }

    public Optional<Roaster> getRoasterById(int id) {
        return roasterRepository.findById(id);
    }

    public Roaster saveRoaster(Roaster roaster) {
        return roasterRepository.save(roaster);
    }

    public void deleteRoaster(int id) {
        Roaster roaster = roasterRepository.findById(id).orElse(null);
        if (roaster != null) {
            roaster.setDeleteFlag(true);
            roasterRepository.save(roaster);
        }
    }
}
