package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.dto.UserRequest;
import com.user.dto.UserResponse;
import com.user.service.UserService;

@Controller
@RequestMapping("/user/view")
public class ViewController {

    private final UserService userService;

    // Constructor-based dependency injection
    @Autowired
    public ViewController(UserService userService) {
        this.userService = userService;
    }

    // Get mapping to show the form for adding a user
    @GetMapping("/add")
    public String showAddUserForm() {
        return "addUser";  // This will resolve to /WEB-INF/jsp/addUser.jsp
    }

  //   Post mapping to handle adding a user
    @PostMapping("/add")
    public String addUser(@RequestParam String firstName,
                          @RequestParam String lastName,
                          @RequestParam String email,
                          @RequestParam String password,
                          @RequestParam Long contact,
                          @RequestParam String address) {
        // Create UserRequest and call the UserService to add the user
        UserRequest userRequest = new UserRequest(firstName, lastName, email, password, contact, address);
        userService.addUser(userRequest);
        return "redirect:/user/view/all";  // Redirect to view all users
    }
//
//    // Get mapping to delete a user
//    @GetMapping("/delete/{id}")
//    public String showDeleteUserForm(@PathVariable Long id, Model model) {
//        // Optionally, you can pass user data to the model for confirmation
//        UserResponse user = userService.getUserById(id);
//        model.addAttribute("user", user);
//        return "deleteUser";  // This will resolve to /WEB-INF/jsp/deleteUser.jsp
//    }
//
//    // Get mapping to update a user
//    @GetMapping("/update/{id}")
//    public String showUpdateUserForm(@PathVariable Long id, Model model) {
//        UserResponse user = userService.getUserById(id);
//        model.addAttribute("user", user);
//        return "updateUser";  // This will resolve to /WEB-INF/jsp/updateUser.jsp
//    }
//
//    // Post mapping to handle updating a user
//    @PostMapping("/update/{id}")
//    public String updateUser(@PathVariable Long id, @RequestParam String firstName,
//                             @RequestParam String lastName,
//                             @RequestParam String email,
//                             @RequestParam String password,
//                             @RequestParam Long contact,
//                             @RequestParam String address) {
//        UserRequest userRequest = new UserRequest(firstName, lastName, email, password, contact, address);
//        userService.updateUser(id, userRequest);
//        return "redirect:/user/view/all";  // Redirect to view all users
//    }
//
    // Get mapping to view all users
    @GetMapping("/all")
    public String viewAllUsers(Model model) {
        List<UserResponse> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "viewAllUsers";  // This will resolve to /WEB-INF/jsp/viewAllUsers.jsp
    }
//
//    // Get mapping to view a single user by ID
//    @GetMapping("/{id}")
//    public String viewUser(@PathVariable Long id, Model model) {
//        UserResponse user = userService.getUserById(id);
//        if (user != null) {
//            model.addAttribute("user", user);
//            return "viewUser";  // This will resolve to /WEB-INF/jsp/viewUser.jsp
//        } else {
//            return "redirect:/user/view/all";  // Redirect if user not found
//        }
//    }
}
