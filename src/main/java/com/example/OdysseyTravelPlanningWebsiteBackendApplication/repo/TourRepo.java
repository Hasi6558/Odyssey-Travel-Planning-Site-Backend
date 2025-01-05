package com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Tour;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TourRepo extends MongoRepository<Tour, String> {
    @Query("{ 'location_city': { $regex: ?0, $options: 'i' } }")
    List<Tour> findByCityContaining(String searchTerm);




}
