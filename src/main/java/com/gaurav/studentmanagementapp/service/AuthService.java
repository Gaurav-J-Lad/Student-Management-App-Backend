package com.gaurav.studentmanagementapp.service;

// ================= IMPORTS =================

import com.gaurav.studentmanagementapp.entity.User;

// ================= SERVICE INTERFACE =================

public interface AuthService {

    // =========================================================
    // REGISTER NEW USER
    // =========================================================
    String register(User user);

    // =========================================================
    // LOGIN USER (AUTHENTICATION)
    // RETURNS USER IF CREDENTIALS ARE VALID
    // =========================================================
    User login(String username, String password);
}