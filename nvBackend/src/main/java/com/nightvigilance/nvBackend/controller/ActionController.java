package com.nightvigilance.nvBackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nightvigilance.nvBackend.DTO.ActionDTO;
import com.nightvigilance.nvBackend.model.Action;
import com.nightvigilance.nvBackend.model.Img;
import com.nightvigilance.nvBackend.model.Roaster;
import com.nightvigilance.nvBackend.service.ActionService;
import com.nightvigilance.nvBackend.service.RoasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/action")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @Autowired
    private RoasterService roasterService;

    @PostMapping
    public Action createAction(@RequestBody String actionDTOJson) {
        // Log the received JSON
        System.out.println("Received JSON: " + actionDTOJson);

        // Deserialize the JSON string to ActionDTO
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        ActionDTO actionDTO = null;
        try {
            actionDTO = objectMapper.readValue(actionDTOJson, ActionDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception (e.g., return an error response)
            return null; // Ideally, return a proper error response
        }

        // Create Action entity from ActionDTO
        Action action = new Action();
        action.setEmpName(actionDTO.getEmpName());
        action.setEmpId(actionDTO.getEmpId());
        action.setDept(actionDTO.getDept());  // Ensure this is set
        action.setDesig(actionDTO.getDesig());
        action.setEmail(actionDTO.getEmail());
        action.setActionName(actionDTO.getActionName());

        // Fetch the Roaster by id
        Roaster roaster = roasterService.getRoasterById(actionDTO.getRoasterId()).orElse(null);
        if (roaster == null) {
            // Handle the case when Roaster is not found
            return null; // Ideally, return a proper error response
        }
        action.setRoaster(roaster);

        action.setCreatedBy(actionDTO.getCreatedBy());
        action.setCreatedOn(actionDTO.getCreatedOn() != null ? actionDTO.getCreatedOn() : LocalDateTime.now());
        action.setUpdatedBy(actionDTO.getUpdatedBy());
        action.setUpdatedOn(actionDTO.getUpdatedOn() != null ? actionDTO.getUpdatedOn() : LocalDateTime.now());
        action.setDeleteFlag(actionDTO.isDeleteFlag());


        // Save Action
        return actionService.saveAction(action);
    }
    @GetMapping("/{id}")
    public Action getActionById(@PathVariable int id) {
        return actionService.getActionById(id);
    }
    @PostMapping("/{actionId}/images")
    public Img addImageToAction(@PathVariable int actionId, @RequestBody Img img) {
        return actionService.addImageToAction(actionId, img);
    }
    @DeleteMapping("/{id}")
    public void deleteAction(@PathVariable int id) {
        actionService.deleteAction(id);
    }
}
