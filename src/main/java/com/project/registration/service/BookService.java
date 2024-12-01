package com.project.registration.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.registration.model.Books;
import com.project.registration.model.User;
import com.project.registration.repository.BookRepository;
import com.project.registration.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookService 
{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;


    public Books addBooks(Books books) 
    {
        return bookRepository.save(books);
    }

    public List<Books> getAllBooks() 
    {
        return bookRepository.findAll();
    }

    public Books assignBookToUser(Long bookId, String username) 
    {
        // Find the user by username
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Find the book by ID and check availability
        Books book = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found"));
        
        if (!book.isAvailable()) 
        {
            throw new IllegalStateException("Book is already assigned");
        }
        
        // Assign the book to the user and mark as unavailable
        book.setAssignedTo(user);
        book.setAvailable(false);
        book.setIssuedDate(LocalDateTime.now());
        
        return bookRepository.save(book);
    }

    public Books returnBook(Long bookId, String username) 
    {
        // Check if the user owns the book they want to return
        Books book = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found"));

        if (book.getAssignedTo() == null || !book.getAssignedTo().getUsername().equals(username)) 
        {
            throw new IllegalStateException("User does not have this book");
        }
        
        // Set book availability back and remove user association
        book.setAssignedTo(null);
        book.setAvailable(true);
        book.setReleaseDate(LocalDateTime.now());

        return bookRepository.save(book);
    }
    
}
