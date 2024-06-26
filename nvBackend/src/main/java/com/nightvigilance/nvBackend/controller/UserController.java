package com.nightvigilance.nvBackend.controller;

import com.nightvigilance.nvBackend.DTO.UserDTO;
import com.nightvigilance.nvBackend.model.User;
import com.nightvigilance.nvBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        User existingUser = userService.findUserByUserMail(userDTO.getUserMail());
        if (existingUser != null) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        User user = userService.registerUser(userDTO.getUserMail(), userDTO.getUserName(), userDTO.getPassword());
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO) {
        User user = userService.findUserByUserMail(userDTO.getUserMail());
        if (user == null || !userService.checkPassword(userDTO.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
