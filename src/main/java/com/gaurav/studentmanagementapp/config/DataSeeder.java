package com.gaurav.studentmanagementapp.config;

// ================= IMPORTS =================

import com.gaurav.studentmanagementapp.entity.Course;
import com.gaurav.studentmanagementapp.entity.Role;
import com.gaurav.studentmanagementapp.entity.User;

import com.gaurav.studentmanagementapp.repository.CourseRepository;
import com.gaurav.studentmanagementapp.repository.RoleRepository;
import com.gaurav.studentmanagementapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


// =========================================================
// DATA SEEDER
// RUNS AUTOMATICALLY WHEN APPLICATION STARTS
// USED TO INSERT DEFAULT ROLES, COURSES, AND ADMIN USER
// =========================================================

@Component
public class DataSeeder implements CommandLineRunner {

    // ================= REPOSITORIES =================

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private UserRepository userRepo;

    // =========================================================
    // RUN METHOD (AUTO EXECUTED ON STARTUP)
    // =========================================================

    @Override
    public void run(String... args) {

        // =====================================================
        // INSERT DEFAULT ROLES
        // =====================================================

        if (roleRepo.count() == 0) {

            roleRepo.save(new Role(null, "ADMIN"));
            roleRepo.save(new Role(null, "STUDENT"));
        }

        // =====================================================
        // INSERT DEFAULT COURSES
        // =====================================================

        if (courseRepo.count() == 0) {

            courseRepo.save(new Course(null, "BCA"));
            courseRepo.save(new Course(null, "MCA"));
            courseRepo.save(new Course(null, "BSc IT"));
            courseRepo.save(new Course(null, "MSc IT"));
            courseRepo.save(new Course(null, "B COM"));
            courseRepo.save(new Course(null, "M COM"));

        }

        // =====================================================
        // CREATE DEFAULT ADMIN USER
        // =====================================================

        if (userRepo.count() == 0) {

            // FETCH ADMIN ROLE SAFELY
            Role adminRole = roleRepo.findByRoleName("ADMIN")
                    .orElseThrow(() -> new RuntimeException("ADMIN role not found"));

            // CREATE ADMIN USER
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("admin123");
            admin.setRole(adminRole);

            // SAVE USER
            userRepo.save(admin);
        }
    }
}