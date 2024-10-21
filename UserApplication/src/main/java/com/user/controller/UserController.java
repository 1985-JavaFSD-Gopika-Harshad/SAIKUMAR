package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.UserRequest;
import com.user.dto.UserResponse;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	} 
	@PostMapping
	public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest){
		UserResponse user=userService.addUser(userRequest);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	 @GetMapping("/{id}")
	    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
	        UserResponse userResponse = userService.getUserById(id);
	        if (userResponse != null) {
	            return new ResponseEntity<>(userResponse, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 @GetMapping
	    public ResponseEntity<List<UserResponse>> getAllUsers() {
	        List<UserResponse> users = userService.getAllUsers();
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }
	 @PutMapping("/{id}")
	    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
	        UserResponse updatedUser = userService.updateUser(id, userRequest);
	        if (updatedUser != null) {
	            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
	        userService.deleteUser(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

}
