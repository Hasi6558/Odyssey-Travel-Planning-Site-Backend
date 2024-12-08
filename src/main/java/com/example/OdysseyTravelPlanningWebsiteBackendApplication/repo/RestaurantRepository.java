package com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Restaurant;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {

   

}
