package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.impl;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.RoomBooking;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo.RoomBookingRepository;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.RoomBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomBookingServiceImpl implements RoomBookingService {

    @Autowired
    private RoomBookingRepository repository;

    @Override
    public List<RoomBooking> getAllRoomBookings() {
        return repository.findAll();
    }

    @Override
    public Optional<RoomBooking> getRoomBookingById(String id) {
        return repository.findById(id);
    }

    @Override
    public RoomBooking createRoomBooking(RoomBooking roomBooking) {
        return repository.save(roomBooking);
    }

    @Override
    public RoomBooking updateRoomBooking(String id, RoomBooking roomBooking) {
        if (repository.existsById(id)) {
            roomBooking.setId(id);
            return repository.save(roomBooking);
        }
        return null;
    }

    @Override
    public void deleteRoomBooking(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<RoomBooking> getAllRoomBookingsByUserId(String userId) {
        return repository.findByUserId(userId);
    }

}