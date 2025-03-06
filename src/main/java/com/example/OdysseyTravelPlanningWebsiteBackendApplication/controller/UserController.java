package com.example.OdysseyTravelPlanningWebsiteBackendApplication.controller;

import org.springframework.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.User;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    // Create User
    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }

    // Get All Users
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get User By ID
    // @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update User
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User userDetails) {
        return ResponseEntity.ok(userService.updateUser(id, userDetails));
    }

    // Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
