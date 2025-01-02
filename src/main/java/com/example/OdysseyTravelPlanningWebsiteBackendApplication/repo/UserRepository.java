package com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.User;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);

}
