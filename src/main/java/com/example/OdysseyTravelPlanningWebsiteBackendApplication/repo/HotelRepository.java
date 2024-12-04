package com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, String> {

}
