package com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.HotelRoom;
import java.util.List;

public interface HotelRoomRepository extends MongoRepository<HotelRoom, String> {
    List<HotelRoom> findByHotelId(String hotelId);
}
