package com.project.registration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.registration.model.Role;
import com.project.registration.repository.RoleRepository;

@Component
public class DataInitializer implements CommandLineRunner 
{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) 
    {
        // Initialize roles if they don't exist
        if (roleRepository.findByName("USER").isEmpty()) 
        {
            roleRepository.save(new Role("USER"));
        }

        if (roleRepository.findByName("ADMIN").isEmpty()) 
        {
            roleRepository.save(new Role("ADMIN"));
        }
    }
}

