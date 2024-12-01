package com.project.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.registration.model.Role;
import com.project.registration.service.RoleService;


@RestController
@RequestMapping("/role")
public class RoleController 
{
    @Autowired
    private RoleService roleService;


    @PostMapping("/add-role")
    public void addRole(@RequestBody Role role)
    {
        roleService.addRole(role);
        System.out.println("ROLE added successfuly");
    }

    @GetMapping("/get-roles")
    public List<Role> getMethodName() 
    {
        return roleService.getAllRoles();
    }
    
}
