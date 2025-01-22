package com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Hotel;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface HotelRepository extends MongoRepository<Hotel, String> {
    @Query("{'locationCity': {$regex: ?0, $options: 'i'}}")
    List<Hotel> findByLocationCitySubstring(String searchTerm);

}
