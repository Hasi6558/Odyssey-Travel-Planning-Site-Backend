package com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.HotelRoom;

public interface HotelRoomRepository extends MongoRepository<HotelRoom, String> {

}
