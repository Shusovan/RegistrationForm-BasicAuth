package com.project.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.registration.dto.UserDto;
import com.project.registration.model.User;
import com.project.registration.service.UserService;


@RestController
@RequestMapping("/user")
public class ProfileController 
{

    @Autowired
    private UserService userService;
    

    @GetMapping("/profile")
    public String getMethodName() 
    {
        return "Welcome to your profile";
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<List<User>> getAllUsers()
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("/books")
    public ResponseEntity<UserDto> getCurrentUserWithBooks() 
    {
        UserDto userWithBooks = userService.getCurrentUserWithBooks();
        return ResponseEntity.ok(userWithBooks);
    }
    
}
