package com.nightvigilance.nvBackend.service;

import com.nightvigilance.nvBackend.model.Members;
import com.nightvigilance.nvBackend.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembersService {
    @Autowired
    private MembersRepository membersRepository;

    public List<Members> getAllMembers() {
        return membersRepository.findAll();
    }

    public Members getMembersById(int id) {
        Optional<Members> optionalMember = membersRepository.findById(id);
        return optionalMember.orElse(null);
    }

    public void deleteMembers(int id) {
        membersRepository.deleteById(id);
    }

    public Members saveMember(Members member) {
        return membersRepository.save(member);
    }

}
