package com.gaurav.studentmanagementapp.repository;

// ================= IMPORTS =================

import com.gaurav.studentmanagementapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// ================= REPOSITORY =================

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // =========================================================
    // FIND USER BY USERNAME (USED FOR LOGIN)
    // =========================================================
    Optional<User> findByUsername(String username);
}