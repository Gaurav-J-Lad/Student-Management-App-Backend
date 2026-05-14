package com.gaurav.studentmanagementapp.entity;

// ================= IMPORTS =================

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

// ================= ENTITY =================

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    // =========================================================
    // PRIMARY KEY
    // =========================================================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false, updatable = false)
    private Long id;

    // =========================================================
    // ROLE NAME COLUMN
    // =========================================================

    @Column(
            name = "role_name",
            nullable = false,
            unique = true,
            length = 50
    )
    private String roleName;
}