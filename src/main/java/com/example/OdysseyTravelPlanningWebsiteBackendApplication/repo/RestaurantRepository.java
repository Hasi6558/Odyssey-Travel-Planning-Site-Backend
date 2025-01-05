package com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Restaurant;
import org.springframework.data.mongodb.repository.Query;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
    @Query("{ 'location_city': { $regex: ?0, $options: 'i' } }")
    List<Restaurant> findByCityContaining(String searchTerm);


   

}
