package com.nightvigilance.nvBackend.service;

import com.nightvigilance.nvBackend.model.User;
import com.nightvigilance.nvBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(String userMail, String userName) {
        User user = new User();
        user.setUserMail(userMail);
        user.setUserName(userName);
        userRepository.save(user);
        return user;
    }

    public User findUserByUserMail(String userMail) {
        return userRepository.findByUserMail(userMail);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}