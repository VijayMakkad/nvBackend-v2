package com.nightvigilance.nvBackend.controller;

import com.nightvigilance.nvBackend.DTO.MemberDTO;
import com.nightvigilance.nvBackend.DTO.RoasterDTO;
import com.nightvigilance.nvBackend.model.Action;
import com.nightvigilance.nvBackend.model.Members;
import com.nightvigilance.nvBackend.model.Roaster;
import com.nightvigilance.nvBackend.service.ActionService;
import com.nightvigilance.nvBackend.service.MembersService;
import com.nightvigilance.nvBackend.service.RoasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/roaster")
public class RoasterController {

    @Autowired
    private RoasterService roasterService;

    @Autowired
    private MembersService membersService;

    @Autowired
    private ActionService actionService;

    @PostMapping
    public Roaster addRoaster(@RequestBody RoasterDTO roasterDTO) {
        Roaster roaster = new Roaster();
        roaster.setDateTime(Timestamp.valueOf(LocalDateTime.parse(roasterDTO.getDateTime())));

        Action action = actionService.getActionById(roasterDTO.getActionId());
        roaster.setAction(action);

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
            System.out.println(":------------>>>>:"+memberDTO.isTeamHead());
            member.setTeamHead(memberDTO.isTeamHead());

            member.setShiftIncharge(memberDTO.isShiftIncharge());
            member.setSecStaff(memberDTO.isSecStaff());
            membersList.add(membersService.saveMember(member));
        }

        savedRoaster.setMembers(membersList);

        return savedRoaster;
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
        roasterService.deleteRoaster(id);
    }
}
