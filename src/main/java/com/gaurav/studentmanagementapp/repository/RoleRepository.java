package com.gaurav.studentmanagementapp.repository;

// ================= IMPORTS =================

import com.gaurav.studentmanagementapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// ================= REPOSITORY =================

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // =========================================================
    // FIND ROLE BY ROLE NAME
    // =========================================================
    Optional<Role> findByRoleName(String roleName);
}