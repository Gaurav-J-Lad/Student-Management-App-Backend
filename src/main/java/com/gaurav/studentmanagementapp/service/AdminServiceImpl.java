package com.gaurav.studentmanagementapp.service;

// ================= IMPORTS =================

import com.gaurav.studentmanagementapp.entity.Course;
import com.gaurav.studentmanagementapp.entity.Student;
import com.gaurav.studentmanagementapp.entity.User;
import com.gaurav.studentmanagementapp.repository.CourseRepository;
import com.gaurav.studentmanagementapp.repository.StudentRepository;
import com.gaurav.studentmanagementapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

// ================= SERVICE IMPLEMENTATION =================

@Service
public class AdminServiceImpl implements AdminService {

    // ================= REPOSITORIES =================

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private CourseRepository courseRepo;

    // =========================================================
    // CREATE STUDENT PROFILE
    // =========================================================

    @Override
    public ResponseEntity<Map<String, String>> createStudentProfile(Long userId, Student student) {

        // FIND USER
        User user = userRepo.findById(userId).orElse(null);

        if (user == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", "User Not Found"));
        }

        // VALIDATE COURSE INPUT
        if (student.getCourse() == null || student.getCourse().getId() == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", "Course is required"));
        }

        // FETCH COURSE
        Course course = courseRepo.findById(student.getCourse().getId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        student.setCourse(course);

        // SAVE STUDENT
        Student savedStudent = studentRepo.save(student);

        // LINK TO USER
        user.setStudent(savedStudent);
        userRepo.save(user);

        return ResponseEntity.ok(Map.of("message", "Created Successfully"));
    }

    // =========================================================
    // GET ALL USERS
    // =========================================================

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepo.findAll());
    }

    // =========================================================
    // GET ALL COURSES
    // =========================================================

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    // =========================================================
    // UPDATE STUDENT PROFILE
    // =========================================================

    @Override
    public ResponseEntity<String> updateStudent(Long studentId, Student student) {

        Student existing = studentRepo.findById(studentId).orElse(null);

        if (existing == null) {
            return ResponseEntity.badRequest().body("Student not found");
        }

        // VALIDATE COURSE
        if (student.getCourse() == null || student.getCourse().getId() == null) {
            return ResponseEntity.badRequest().body("Course is required");
        }

        Course course = courseRepo.findById(student.getCourse().getId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // UPDATE FIELDS
        existing.setName(student.getName());
        existing.setAddress(student.getAddress());
        existing.setAttendance(student.getAttendance());
        existing.setFeeStatus(student.getFeeStatus());
        existing.setCourse(course);

        studentRepo.save(existing);

        return ResponseEntity.ok("Profile Updated");
    }

    // =========================================================
    // DELETE STUDENT PROFILE
    // =========================================================

    @Override
    public ResponseEntity<String> deleteStudent(Long studentId) {

        Student student = studentRepo.findById(studentId).orElse(null);

        if (student == null) {
            return ResponseEntity.badRequest().body("Student not found");
        }

        // BREAK USER RELATION BEFORE DELETE
        List<User> users = userRepo.findAll();

        for (User u : users) {
            if (u.getStudent() != null &&
                    u.getStudent().getId().equals(studentId)) {

                u.setStudent(null);
                userRepo.save(u);
            }
        }

        studentRepo.delete(student);

        return ResponseEntity.ok("Profile Deleted");
    }
}