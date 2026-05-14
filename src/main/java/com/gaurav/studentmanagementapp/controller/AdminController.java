package com.gaurav.studentmanagementapp.controller;

// ================= IMPORTS =================

import com.gaurav.studentmanagementapp.entity.Course;
import com.gaurav.studentmanagementapp.entity.Student;
import com.gaurav.studentmanagementapp.entity.User;
import com.gaurav.studentmanagementapp.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// ================= CONTROLLER =================

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    // ================= SERVICE INJECTION =================

    @Autowired
    private AdminService adminService;

    // =========================================================
    // CREATE STUDENT PROFILE
    // URL : POST /api/admin/create-profile/{userId}
    // =========================================================

    @PostMapping("/create-profile/{userId}")
    public ResponseEntity<Map<String, String>> createProfile(

            // USER ID FROM URL
            @PathVariable Long userId,

            // STUDENT DATA FROM REQUEST BODY
            @RequestBody Student student) {

        // CALL SERVICE METHOD
        return adminService.createStudentProfile(userId, student);
    }

    // =========================================================
    // GET ALL USERS
    // URL : GET /api/admin/users
    // =========================================================

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {

        // RETURN ALL USERS
        return adminService.getAllUsers();
    }

    // =========================================================
    // GET ALL COURSES
    // URL : GET /api/admin/courses
    // =========================================================

    @GetMapping("/courses")
    public List<Course> getAllCourses() {

        // RETURN COURSE LIST
        return adminService.getAllCourses();
    }

    // =========================================================
    // UPDATE STUDENT PROFILE
    // URL : PUT /api/admin/student/{id}
    // =========================================================

    @PutMapping("/student/{id}")
    public ResponseEntity<String> updateProfile(

            // STUDENT ID
            @PathVariable Long id,

            // UPDATED STUDENT DATA
            @RequestBody Student student) {

        // CALL UPDATE SERVICE
        return adminService.updateStudent(id, student);
    }

    // =========================================================
    // DELETE STUDENT PROFILE
    // URL : DELETE /api/admin/student/{id}
    // =========================================================

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteProfile(

            // STUDENT ID
            @PathVariable Long id) {

        // CALL DELETE SERVICE
        return adminService.deleteStudent(id);
    }
}