package com.gaurav.studentmanagementapp.entity;

// ================= IMPORTS =================

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// ================= ENTITY =================

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    // =========================================================
    // PRIMARY KEY
    // =========================================================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, updatable = false)
    private Long id;

    // =========================================================
    // USERNAME (LOGIN ID)
    // =========================================================

    @Column(
            name = "username",
            nullable = false,
            unique = true,
            length = 50
    )
    private String username;

    // =========================================================
    // PASSWORD
    // =========================================================

    @Column(
            name = "password",
            nullable = false,
            length = 255
    )
    private String password;

    // =========================================================
    // ROLE RELATION (MANY USERS → ONE ROLE)
    // =========================================================

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    // =========================================================
    // STUDENT RELATION (ONLY IF USER IS STUDENT)
    // =========================================================

    @OneToOne
    @JoinColumn(name = "student_id", unique = true)
    private Student student;
}