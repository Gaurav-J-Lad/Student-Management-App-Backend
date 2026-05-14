package com.gaurav.studentmanagementapp.repository;

// ================= IMPORTS =================

import com.gaurav.studentmanagementapp.entity.Student;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

// ================= REPOSITORY =================

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // =========================================================
    // FIND STUDENT BY NAME
    // =========================================================
    Optional<Student> findByName(String name);

    // =========================================================
    // FIND STUDENTS BY COURSE ID
    // =========================================================
    @Query("SELECT s FROM Student s WHERE s.course.id = :courseId")
    List<Student> findByCourseId(@Param("courseId") Long courseId);

    // =========================================================
    // FIND STUDENTS WITH LOW ATTENDANCE (< 75)
    // =========================================================
    @Query("SELECT s FROM Student s WHERE s.attendance < 75")
    List<Student> findLowAttendanceStudents();
}