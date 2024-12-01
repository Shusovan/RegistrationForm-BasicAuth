package com.project.registration.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BooksDto 
{

    private Long bookId;
    
    private String title;
    
    private String author;
    
    private LocalDateTime issuedDate;
    
    private LocalDateTime releaseDate;

}
