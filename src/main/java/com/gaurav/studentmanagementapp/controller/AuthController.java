package com.gaurav.studentmanagementapp.controller;

// ================= IMPORTS =================

import com.gaurav.studentmanagementapp.entity.User;
import com.gaurav.studentmanagementapp.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// ================= CONTROLLER =================

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    // ================= SERVICE INJECTION =================

    @Autowired
    private AuthService authService;

    // =========================================================
    // USER REGISTRATION
    // URL : POST /api/auth/register
    // =========================================================

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(

            // USER DATA FROM REQUEST BODY
            @RequestBody User user) {

        // CALL SERVICE TO REGISTER USER
        authService.register(user);

        // RESPONSE MESSAGE
        Map<String, String> res = new HashMap<>();
        res.put("message", "User Registered");

        return ResponseEntity.ok(res);
    }

    // =========================================================
    // USER LOGIN
    // URL : POST /api/auth/login
    // =========================================================

    @PostMapping("/login")
    public User login(

            // LOGIN CREDENTIALS FROM REQUEST BODY
            @RequestBody User user) {

        // CALL SERVICE TO AUTHENTICATE USER
        return authService.login(user.getUsername(), user.getPassword());
    }
}