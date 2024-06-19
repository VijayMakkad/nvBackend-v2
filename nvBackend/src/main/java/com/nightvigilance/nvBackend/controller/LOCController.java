package com.nightvigilance.nvBackend.controller;

import com.nightvigilance.nvBackend.model.LOC;
import com.nightvigilance.nvBackend.service.LOCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loc")
public class LOCController {
    @Autowired
    private LOCService locService;

    @GetMapping
    public List<LOC> getAllLocations() {
        return locService.getAllLocations();
    }

    @GetMapping("/{id}")
    public LOC getLocationById(@PathVariable int id) {
        return locService.getLocationById(id);
    }

    @PostMapping
    public LOC saveLocation(@RequestBody LOC loc) {
        return locService.saveLocation(loc);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable int id) {
        locService.deleteLocation(id);
}
}
