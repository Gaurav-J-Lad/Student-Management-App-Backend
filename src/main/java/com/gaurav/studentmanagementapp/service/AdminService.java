package com.gaurav.studentmanagementapp.service;

// ================= IMPORTS =================

import com.gaurav.studentmanagementapp.entity.Course;
import com.gaurav.studentmanagementapp.entity.Student;
import com.gaurav.studentmanagementapp.entity.User;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Map;

// ================= SERVICE INTERFACE =================

public interface AdminService {

    // =========================================================
    // CREATE STUDENT PROFILE FOR A USER
    // =========================================================
    ResponseEntity<Map<String, String>> createStudentProfile(Long userId, Student student);

    // =========================================================
    // GET ALL USERS (ADMIN VIEW)
    // =========================================================
    ResponseEntity<List<User>> getAllUsers();

    // =========================================================
    // GET ALL COURSES
    // =========================================================
    List<Course> getAllCourses();

    // =========================================================
    // UPDATE STUDENT DETAILS
    // =========================================================
    ResponseEntity<String> updateStudent(Long studentId, Student student);

    // =========================================================
    // DELETE STUDENT PROFILE
    // =========================================================
    ResponseEntity<String> deleteStudent(Long studentId);
}