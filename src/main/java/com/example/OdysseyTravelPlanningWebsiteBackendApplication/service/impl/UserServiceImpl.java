package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.impl;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.ApiResponse;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.LoginResponse;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.User;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo.UserRepository;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.JWTService;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public ResponseEntity<User> createUser(User user) {
        User checkUser = userRepository.findByUsername(user.getUsername());
        if (checkUser != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        user.setPassword(encoder.encode(user.getPassword()));
        User createdUser = userRepository.insert(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(String id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setRole(userDetails.getRole());
            user.setAddress(userDetails.getAddress());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<?> loginUser(User user) {
        Authentication auth = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),
                        user.getPassword()));
        if (auth.isAuthenticated()) {
            String token = jwtService.generateToken(user.getUsername());
            String loggedInUser = userRepository.findByUsername(user.getUsername()).getId();
            String fName = userRepository.findByUsername(user.getUsername()).getFirstName();
            String lName = userRepository.findByUsername(user.getUsername()).getLastName();
            String fullName = fName + " " + lName;
            return ResponseEntity.ok(new LoginResponse("Login successful", token, loggedInUser, fullName));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse("User not logged in"));
        }
    }
}
