package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Author;
import com.example.demo.Service.AuthorService;

@RestController
public class AuthorController {
	@Autowired
	AuthorService authorService;
	 @PostMapping
	    public ResponseEntity<Author> createAuthor(@RequestBody Author authorRequest) {
	        Author createdAuthor = authorService.createAuthor(authorRequest);
	        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
	    }
	 @GetMapping
	 public List<Author> getallAuthor(){
		 	List<Author> author=authorService.getallauthor();
		 	return author;
	 }
	 

	 
}
