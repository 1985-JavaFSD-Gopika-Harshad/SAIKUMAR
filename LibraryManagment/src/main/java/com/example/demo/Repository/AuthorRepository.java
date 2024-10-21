package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Author;


import com.example.demo.Model.Book;
public interface AuthorRepository extends JpaRepository<Author, Long> {
	   List<Author> findByNameContaining(String name);
}

