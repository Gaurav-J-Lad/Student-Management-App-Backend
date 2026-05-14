package com.gaurav.studentmanagementapp.entity;

// ================= IMPORTS =================

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

// ================= ENTITY =================

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    // =========================================================
    // PRIMARY KEY
    // =========================================================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false, updatable = false)
    private Long id;

    // =========================================================
    // COURSE NAME COLUMN
    // =========================================================

    @Column(
            name = "course_name",
            nullable = false,
            length = 100,
            unique = true
    )
    private String courseName;
}