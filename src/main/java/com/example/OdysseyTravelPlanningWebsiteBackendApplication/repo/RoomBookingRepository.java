package com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.RoomBooking;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomBookingRepository extends MongoRepository<RoomBooking, String> {
    List<RoomBooking> findByUserId(String userId);
}