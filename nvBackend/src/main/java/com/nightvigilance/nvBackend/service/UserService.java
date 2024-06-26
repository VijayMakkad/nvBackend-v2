package com.nightvigilance.nvBackend.service;

import com.nightvigilance.nvBackend.model.User;
import com.nightvigilance.nvBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User registerUser(String userMail, String userName, String password) {
        User existingUser = userRepository.findByUserMail(userMail);
        if (existingUser != null) {
            throw new RuntimeException("User already exists");
        }

        String hashedPassword = passwordEncoder.encode(password);

        User user = new User();
        user.setUserMail(userMail);
        user.setUserName(userName);
        user.setPassword(hashedPassword);

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

    public boolean checkPassword(String plainPassword, String hashedPassword) {
        return passwordEncoder.matches(plainPassword, hashedPassword);
    }

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
