package com.gaurav.studentmanagementapp.service;

// ================= IMPORTS =================

import com.gaurav.studentmanagementapp.entity.Role;
import com.gaurav.studentmanagementapp.entity.User;
import com.gaurav.studentmanagementapp.repository.RoleRepository;
import com.gaurav.studentmanagementapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

// ================= SERVICE IMPLEMENTATION =================

@Service
public class AuthServiceImpl implements AuthService {

    // ================= REPOSITORIES =================

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    // =========================================================
    // USER REGISTRATION
    // DEFAULT ROLE = STUDENT
    // =========================================================

    @Override
    public String register(User user) {

        // FETCH STUDENT ROLE SAFELY
        Role role = roleRepo.findById(2L)
                .orElseThrow(() -> new RuntimeException("STUDENT role not found"));

        // ASSIGN ROLE
        user.setRole(role);

        // SAVE USER
        userRepo.save(user);

        return "User Registered Successfully";
    }

    // =========================================================
    // USER LOGIN
    // VALIDATES USERNAME & PASSWORD
    // =========================================================

    @Override
    public User login(String username, String password) {

        // FIND USER BY USERNAME
        Optional<User> optionalUser = userRepo.findByUsername(username);

        if (optionalUser.isPresent()) {

            User user = optionalUser.get();

            // CHECK PASSWORD
            if (user.getPassword().equals(password)) {
                return user;
            }
        }

        // LOGIN FAILED
        return null;
    }
}