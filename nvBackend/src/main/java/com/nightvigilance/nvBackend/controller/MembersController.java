package com.nightvigilance.nvBackend.controller;

import com.nightvigilance.nvBackend.model.Members;
import com.nightvigilance.nvBackend.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MembersController {
    @Autowired
    private MembersService membersService;

    @GetMapping
    public List<Members> getAllMembers() {
        return membersService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Members getMembersById(@PathVariable int id) {
        return membersService.getMembersById(id);
    }

    @PostMapping
    public Members saveMembers(@RequestBody Members members) {
        return membersService.saveMember(members); // Use saveMember instead of saveMembers
    }


    @DeleteMapping("/{id}")
    public void deleteMembers(@PathVariable int id) {
        membersService.deleteMembers(id);
    }
}
