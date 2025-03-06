package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.RoomBooking;

import java.util.List;
import java.util.Optional;

public interface RoomBookingService {
    List<RoomBooking> getAllRoomBookings();

    Optional<RoomBooking> getRoomBookingById(String id);

    RoomBooking createRoomBooking(RoomBooking roomBooking);

    RoomBooking updateRoomBooking(String id, RoomBooking roomBooking);

    void deleteRoomBooking(String id);

    List<RoomBooking> getAllRoomBookingsByUserId(String userId);
}