package com.project.registration.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserDto 
{   
         
    private Long id;
    
    private String username;
    
    private List<BooksDto> books;
    
}
