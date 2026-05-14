package com.gaurav.studentmanagementapp.entity;

// ================= IMPORTS =================

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

// ================= ENTITY =================

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    // =========================================================
    // PRIMARY KEY
    // =========================================================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false, updatable = false)
    private Long id;

    // =========================================================
    // STUDENT NAME
    // =========================================================

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    // =========================================================
    // COURSE RELATION (MANY STUDENTS → ONE COURSE)
    // =========================================================

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    // =========================================================
    // ATTENDANCE PERCENTAGE
    // =========================================================

    @Column(name = "attendance", nullable = false)
    private Double attendance;

    // =========================================================
    // FEE STATUS (PAID / PENDING)
    // =========================================================

    @Column(name = "fee_status", nullable = false, length = 20)
    private String feeStatus;

    // =========================================================
    // ADDRESS COLUMN
    // =========================================================

    @Column(name = "address", length = 255)
    private String address;
}