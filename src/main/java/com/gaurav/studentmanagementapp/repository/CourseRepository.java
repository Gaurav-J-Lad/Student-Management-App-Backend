package com.gaurav.studentmanagementapp.repository;

// ================= IMPORTS =================

import com.gaurav.studentmanagementapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// ================= REPOSITORY =================

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // =========================================================
    // FIND COURSE BY COURSE NAME
    // =========================================================
    Optional<Course> findByCourseName(String courseName);
}