package com.project.registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.registration.model.Books;

public interface BookRepository extends JpaRepository<Books, Long>
{
    Optional<Books> findByTittle(String tittle);
}
