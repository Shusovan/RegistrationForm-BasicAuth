package com.project.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.registration.model.Role;
import com.project.registration.repository.RoleRepository;

@Service
public class RoleService 
{

    @Autowired
    private RoleRepository roleRepository;

    public void addRole(Role role) 
    {
        roleRepository.save(role);
    }

    public List<Role> getAllRoles() 
    {
        return roleRepository.findAll();
    }
    
}
