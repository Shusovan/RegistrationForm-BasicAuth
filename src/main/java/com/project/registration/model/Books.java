package com.project.registration.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Books 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    @Column(name = "tittle")
    private String tittle;

    @Column(name = "author")
    private String author;

    @Column(name = "isAvailable")
    private boolean isAvailable = true;

    @Column(name = "issued_date")
    private LocalDateTime issuedDate;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @ManyToOne
    private User assignedTo;

}
