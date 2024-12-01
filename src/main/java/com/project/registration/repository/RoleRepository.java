package com.project.registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.registration.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> 
{
    Optional<Role> findByName(String name);
    
    boolean existsByName(String name);
}