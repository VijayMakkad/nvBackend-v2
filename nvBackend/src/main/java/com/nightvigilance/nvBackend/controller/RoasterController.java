package com.nightvigilance.nvBackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nightvigilance.nvBackend.DTO.MemberDTO;
import com.nightvigilance.nvBackend.DTO.RoasterDTO;
import com.nightvigilance.nvBackend.model.Members;
import com.nightvigilance.nvBackend.model.Roaster;
import com.nightvigilance.nvBackend.service.MembersService;
import com.nightvigilance.nvBackend.service.RoasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/saveRoaster")
public class RoasterController {

    @Autowired
    private RoasterService roasterService;

    @Autowired
    private MembersService membersService;

    @PostMapping
    public Roaster addRoaster(@RequestBody String roasterDTOJson) {
        System.out.println("Received JSON: " + roasterDTOJson);

        ObjectMapper objectMapper = new ObjectMapper();
        RoasterDTO roasterDTO = null;
        try {
            roasterDTO = objectMapper.readValue(roasterDTOJson, RoasterDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        Roaster roaster = new Roaster();
        roaster.setDateTime(Timestamp.valueOf(LocalDateTime.parse(roasterDTO.getDateTime())));
        roaster.setCreatedBy(roasterDTO.getCreatedBy());
        roaster.setCreatedOn(Timestamp.valueOf(LocalDateTime.now()));
        roaster.setDeleteFlag(false);
        roaster.setLocation(roasterDTO.getLocation());

        Roaster savedRoaster = roasterService.saveRoaster(roaster);

        List<Members> membersList = new ArrayList<>();
        for (MemberDTO memberDTO : roasterDTO.getMembers()) {
            Members member = new Members();
            member.setRoaster(savedRoaster);
            member.setMemberName(memberDTO.getMemberName());
            member.setMail(memberDTO.getMail());
            member.setEmpCode(memberDTO.getEmpCode());
            member.setContact(memberDTO.getContact());
            member.setHod(memberDTO.getHod());
            member.setReportingOfficer(memberDTO.getReportingOfficer());
            member.setDepartment(memberDTO.getDepartment());
            member.setDesig(memberDTO.getDesig());
            member.setIsTeamHead(memberDTO.isTeamHead());
            member.setIsShiftIncharge(memberDTO.isShiftIncharge());
            member.setIsSecStaff(memberDTO.isSecStaff());

            membersList.add(membersService.saveMember(member));
        }

        savedRoaster.setMembers(membersList);

        return savedRoaster;
    }

    @PutMapping("/{id}")
    public Roaster updateRoaster(@PathVariable int id, @RequestBody String roasterDTOJson) {
        System.out.println("Received JSON: " + roasterDTOJson);

        ObjectMapper objectMapper = new ObjectMapper();
        RoasterDTO roasterDTO;
        try {
            roasterDTO = objectMapper.readValue(roasterDTOJson, RoasterDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        Roaster roaster = roasterService.getRoasterById(id).orElse(null);
        if (roaster == null) {
            return null;
        }

        roaster.setDateTime(Timestamp.valueOf(LocalDateTime.parse(roasterDTO.getDateTime())));
        roaster.setUpdatedBy(roasterDTO.getUpdatedBy());
        roaster.setUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));
        roaster.setLocation(roasterDTO.getLocation());

        List<Members> existingMembers = roaster.getMembers();
        List<Members> updatedMembers = new ArrayList<>();

        for (MemberDTO memberDTO : roasterDTO.getMembers()) {
            Members member = findMemberByEmpCode(existingMembers, memberDTO.getEmpCode());
            if (member == null) {
                member = new Members();
                member.setRoaster(roaster);
            }

            member.setMemberName(memberDTO.getMemberName());
            member.setMail(memberDTO.getMail());
            member.setEmpCode(memberDTO.getEmpCode());
            member.setContact(memberDTO.getContact());
            member.setHod(memberDTO.getHod());
            member.setReportingOfficer(memberDTO.getReportingOfficer());
            member.setDepartment(memberDTO.getDepartment());
            member.setDesig(memberDTO.getDesig());
            member.setIsTeamHead(memberDTO.isTeamHead());
            member.setIsShiftIncharge(memberDTO.isShiftIncharge());
            member.setIsSecStaff(memberDTO.isSecStaff());

            updatedMembers.add(membersService.saveMember(member));
        }

        roaster.setMembers(updatedMembers);

        return roasterService.saveRoaster(roaster);
    }

    private Members findMemberByEmpCode(List<Members> members, int empCode) {
        for (Members member : members) {
            if (member.getEmpCode() == empCode) {
                return member;
            }
        }
        return null;
    }

    @GetMapping
    public List<Roaster> getAllRoasters() {
        return roasterService.getAllRoasters();
    }

    @GetMapping("/{id}")
    public Roaster getRoasterById(@PathVariable int id) {
        return roasterService.getRoasterById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteRoaster(@PathVariable int id) {
        Roaster roaster = roasterService.getRoasterById(id).orElse(null);
        if (roaster != null) {
            roaster.setDeleteFlag(true);
            roasterService.saveRoaster(roaster);
        }
    }
}
