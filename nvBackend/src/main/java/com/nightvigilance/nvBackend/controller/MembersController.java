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
    @PutMapping("/{id}")
    public Members updateMember(@PathVariable int id, @RequestBody Members member) {
        Members existingMember = membersService.getMembersById(id);
        if (existingMember == null) {
            return null; // Ideally, return a proper error response
        }

        existingMember.setMemberName(member.getMemberName());
        existingMember.setMail(member.getMail());
        existingMember.setEmpCode(member.getEmpCode());
        existingMember.setContact(member.getContact());
        existingMember.setHod(member.getHod());
        existingMember.setReportingOfficer(member.getReportingOfficer());
        existingMember.setDepartment(member.getDepartment());
        existingMember.setDesig(member.getDesig());

        return membersService.saveMember(existingMember);
    }

    @DeleteMapping("/{id}")
    public void deleteMembers(@PathVariable int id) {
        membersService.deleteMembers(id);
    }
}
