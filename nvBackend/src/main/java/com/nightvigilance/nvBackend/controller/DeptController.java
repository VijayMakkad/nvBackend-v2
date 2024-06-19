package com.nightvigilance.nvBackend.controller;

import com.nightvigilance.nvBackend.model.Dept;
import com.nightvigilance.nvBackend.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public List<Dept> getAllDepts() {
        return deptService.getAllDepts();
    }

    @GetMapping("/{id}")
    public Dept getDeptById(@PathVariable int id) {
        return deptService.getDeptById(id);
    }

    @PostMapping
    public Dept saveDept(@RequestBody Dept dept) {
        return deptService.saveDept(dept);
    }

    @DeleteMapping("/{id}")
    public void deleteDept(@PathVariable int id) {
        deptService.deleteDept(id);
}
}