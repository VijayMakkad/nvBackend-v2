package com.nightvigilance.nvBackend.service;

import com.nightvigilance.nvBackend.model.Action;
import com.nightvigilance.nvBackend.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionService {
    @Autowired
    private ActionRepository actionRepository;

    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }

    public Action getActionById(int id) {
        return actionRepository.findById(id).orElse(null);
    }

    public Action saveAction(Action action) {
        return actionRepository.save(action);
    }

    public void deleteAction(int id) {
        actionRepository.deleteById(id);
}
}
