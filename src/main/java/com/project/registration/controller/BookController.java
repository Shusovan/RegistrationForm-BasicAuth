package com.project.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.registration.config.CustomUserDetails;
import com.project.registration.model.Books;
import com.project.registration.service.BookService;


@RestController
@RequestMapping("/books")
public class BookController 
{
    
    @Autowired
    private BookService bookService;


    @PostMapping("/assign/{bookId}")
    public ResponseEntity<Books> assignBook(@PathVariable Long bookId, @AuthenticationPrincipal CustomUserDetails userDetails) 
    {
        String username = userDetails.getUsername();
        Books book = bookService.assignBookToUser(bookId, username);
        return ResponseEntity.ok(book);
    }

    @PostMapping("/return/{bookId}")
    public ResponseEntity<Books> returnBook(@PathVariable Long bookId, @AuthenticationPrincipal CustomUserDetails userDetails) 
    {
        String username = userDetails.getUsername();
        Books book = bookService.returnBook(bookId, username);
        return ResponseEntity.ok(book);
    }
    
}
