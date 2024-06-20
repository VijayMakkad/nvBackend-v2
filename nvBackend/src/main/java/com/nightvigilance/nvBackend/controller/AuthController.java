package com.nightvigilance.nvBackend.controller;

import com.nightvigilance.nvBackend.DTO.UserDTO;
import com.nightvigilance.nvBackend.model.User;
import com.nightvigilance.nvBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO) {
        User user = userService.findUserByUserMail(userDTO.getUserMail());
        if (user == null) {
            userService.registerUser(userDTO.getUserMail(), userDTO.getUserName());
        }
        return "User logged in with email: " + userDTO.getUserMail();
    }
}
