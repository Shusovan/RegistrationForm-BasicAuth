package com.project.registration.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.registration.dto.BooksDto;
import com.project.registration.dto.UserDto;
import com.project.registration.model.Role;
import com.project.registration.model.User;
import com.project.registration.repository.RoleRepository;
import com.project.registration.repository.UserRepository;

@Service
public class UserService 
{
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    
    public User addUser(User user) 
    {
        Set<Role> persistentRoles = new HashSet<>();
        
        System.out.println(user.getRoles());
        
        for (Role role : user.getRoles()) 
        {
            // Find role by name or ID in the database
            Role persistentRole = roleRepository.findByName(role.getName())
                    .orElseThrow(() -> new RuntimeException("Role not found: " + role.getName()));
            persistentRoles.add(persistentRole);
        }
        user.setRoles(persistentRoles);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        return userRepository.save(user);
    }


    public List<User> getAllUsers() 
    {
        List<User> users = userRepository.findAll();
        return users;
    }


    /*
     * description : fetchs the user with books after successfull login
     * method : getCurrentUserWithBooks
     * return : user with books
     */
    public UserDto getCurrentUserWithBooks() 
    {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("USER NOT FOUND"));

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());

        List<BooksDto> booksDto = user.getBooks().stream().map(book -> {
            BooksDto dto = new BooksDto();
            dto.setBookId(book.getBookId());
            dto.setTitle(book.getTittle());
            dto.setAuthor(book.getAuthor());
            dto.setIssuedDate(book.getIssuedDate());
            dto.setReleaseDate(book.getReleaseDate());
            return dto;
        }).collect(Collectors.toList());

        userDto.setBooks(booksDto);

        return userDto;
    }

    

}
