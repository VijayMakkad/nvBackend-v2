package com.nightvigilance.nvBackend.service;

import com.nightvigilance.nvBackend.model.Dept;
import com.nightvigilance.nvBackend.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    @Autowired
    private DeptRepository deptRepository;

    public List<Dept> getAllDepts() {
        return deptRepository.findAll();
    }

    public Dept getDeptById(int id) {
        return deptRepository.findById(id).orElse(null);
    }

    public Dept saveDept(Dept dept) {
        return deptRepository.save(dept);
    }

    public void deleteDept(int id) {
        deptRepository.deleteById(id);
}
}