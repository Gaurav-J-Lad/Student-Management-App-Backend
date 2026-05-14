package com.gaurav.studentmanagementapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class HomeController {

    // ================= HOME PAGE (TEXT RESPONSE) =================
    // URL: GET /

    @GetMapping(value = "/", produces = "text/plain")
    public String home() {

        return """
                🎓 Student Management System Backend is Running Successfully!

                ================= AUTH APIs =================
                POST   /api/auth/register              -> Register User
                POST   /api/auth/login                 -> Login User

                ================= ADMIN APIs =================
                POST   /api/admin/create-profile/{id}  -> Create Student Profile
                GET    /api/admin/users                -> Get All Users
                GET    /api/admin/courses              -> Get All Courses
                PUT    /api/admin/student/{id}         -> Update Student Profile
                DELETE /api/admin/student/{id}         -> Delete Student Profile

                ================= STATUS =================
                Server is up and running ✔
                """;
    }
}