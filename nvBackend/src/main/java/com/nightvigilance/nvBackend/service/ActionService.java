package com.nightvigilance.nvBackend.service;

import com.nightvigilance.nvBackend.model.Action;
import com.nightvigilance.nvBackend.model.Img;
import com.nightvigilance.nvBackend.repository.ActionRepository;
import com.nightvigilance.nvBackend.repository.ImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionService {
    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private ImgRepository imgRepository;

    public Action saveAction(Action action) {
        return actionRepository.save(action);
    }

    public Action getActionById(int id) {
        return actionRepository.findById(id).orElse(null);
    }
    public Img addImageToAction(int actionId, Img img) {
        Action action = getActionById(actionId);
        if (action != null) {
            img.setAction(action);
            return imgRepository.save(img);
        } else {
            throw new RuntimeException("Action not found");
        }
    }
    public void deleteAction(int id) {
        Optional<Action> action = actionRepository.findById(id);
        if (action.isPresent()) {
            Action actionToDelete = action.get();
            actionToDelete.setDeleteFlag(true);
            actionRepository.save(actionToDelete);

            List<Img> imgs = imgRepository.findByActionIdAndDeleteFlagFalse(id);
            for (Img img : imgs) {
                img.setDeleteFlag(true);
                imgRepository.save(img);
            }
        }
    }
}
