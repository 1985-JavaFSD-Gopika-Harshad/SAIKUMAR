package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Author;
import com.example.demo.Repository.AuthorRepository;
@Service
public class AuthorService {
	 @Autowired
	    private AuthorRepository authorRepository;

	    public Author createAuthor(Author authorRequest) {
	        Author author = Author.builder()
	                .name(authorRequest.getName())
	                .biography(authorRequest.getBiography())
	                .build();
	        return authorRepository.save(author);
	    }
	    public List<Author> getallauthor(){
	    	return authorRepository.findAll();
	    }
}
