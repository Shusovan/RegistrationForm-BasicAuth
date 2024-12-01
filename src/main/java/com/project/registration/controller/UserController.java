package com.project.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.registration.model.Books;
import com.project.registration.model.User;
import com.project.registration.service.BookService;
import com.project.registration.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController 
{
    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;


    @PostMapping("/add-user")
    public ResponseEntity<User> addUsers(@RequestBody User user)
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.addUser(user));
    }

    @PostMapping("/add-books")
    public ResponseEntity<Books> addBooks(@RequestBody Books books) 
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBooks(books));
    }

    @GetMapping("/get-books")
    public List<Books> getAllBooks() 
    {
        return bookService.getAllBooks();
    }
    
}
