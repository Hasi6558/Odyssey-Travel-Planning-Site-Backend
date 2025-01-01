package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service;

import java.util.List;
import java.util.Optional;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.User;

public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(String id);

    User updateUser(String id, User userDetails);

    void deleteUser(String id);

    public User getUserByEmail(String email);
}
