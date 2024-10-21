package com.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dto.UserRequest;
import com.user.dto.UserResponse;
import com.user.model.User;
import com.user.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}
	
	public UserResponse addUser(UserRequest userRequest) {
		User user=mapToUser(userRequest);
		user=userRepository.save(user);
		return mapToUserResponse(user);
	}
	 public UserResponse getUserById(Long id) {
	        Optional<User> user = userRepository.findById(id);
	        return user.map(this::mapToUserResponse).orElse(null);
	    }

	    public List<UserResponse> getAllUsers() {
	        List<User> users = (List<User>) userRepository.findAll();
	        return users.stream()
	                    .map(this::mapToUserResponse)
	                    .collect(Collectors.toList());
	    }

	    public UserResponse updateUser(Long id, UserRequest userRequest) {
	        Optional<User> userOptional = userRepository.findById(id);
	        if (userOptional.isPresent()) {
	            User user = userOptional.get();
	            user.setFirstName(userRequest.getFirstName());
	            user.setLastName(userRequest.getLastName());
	            user.setEmail(userRequest.getEmail());
	            user.setPassword(userRequest.getPassword());
	            user.setContact(userRequest.getContact());
	            user.setAddress(userRequest.getAddress());
	            user = userRepository.save(user);
	            return mapToUserResponse(user);
	        }
	        return null; // Handle user not found appropriately in your controller
	    }

	    public void deleteUser(Long id) {
	        userRepository.deleteById(id);
	    }
	
	public User mapToUser(UserRequest user) {
		return User.builder()
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.email(user.getEmail())
				.password(user.getPassword())
				.contact(user.getContact())
				.address(user.getAddress())
				.build();
	}
	
	public UserResponse mapToUserResponse(User user) {
		return UserResponse.builder()
				.id(user.getId())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.email(user.getEmail())
				.password(user.getPassword())
				.contact(user.getContact())
				.address(user.getAddress())
				.build();
	}
}
