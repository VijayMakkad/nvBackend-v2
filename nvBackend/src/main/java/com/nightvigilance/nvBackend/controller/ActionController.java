package com.nightvigilance.nvBackend.controller;

import com.nightvigilance.nvBackend.model.Action;
import com.nightvigilance.nvBackend.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/action")
public class ActionController {
    @Autowired
    private ActionService actionService;

    @GetMapping
    public List<Action> getAllActions() {
        return actionService.getAllActions();
    }

    @GetMapping("/{id}")
    public Action getActionById(@PathVariable int id) {
        return actionService.getActionById(id);
    }

    @PostMapping
    public Action saveAction(@RequestBody Action action) {
        return actionService.saveAction(action);
    }

    @DeleteMapping("/{id}")
    public void deleteAction(@PathVariable int id) {
        actionService.deleteAction(id);
}
}