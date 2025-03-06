package com.example.OdysseyTravelPlanningWebsiteBackendApplication.controller;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.RoomBooking;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.RoomBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/room-bookings")
@CrossOrigin
public class RoomBookingController {

    @Autowired
    private RoomBookingService service;

    @GetMapping
    public List<RoomBooking> getAllRoomBookings() {
        return service.getAllRoomBookings();
    }

    @GetMapping("getRoom/{id}")
    public Optional<RoomBooking> getRoomBookingById(@PathVariable String id) {
        return service.getRoomBookingById(id);
    }

    @PostMapping("/save-booking")
    public RoomBooking createRoomBooking(@RequestBody RoomBooking roomBooking) {
        return service.createRoomBooking(roomBooking);
    }

    @PutMapping("/{id}")
    public RoomBooking updateRoomBooking(@PathVariable String id, @RequestBody RoomBooking roomBooking) {
        return service.updateRoomBooking(id, roomBooking);
    }

    @DeleteMapping("/{id}")
    public void deleteRoomBooking(@PathVariable String id) {
        service.deleteRoomBooking(id);
    }

    @GetMapping("/user/{userId}")
    public List<RoomBooking> getAllRoomBookingsByUserId(@PathVariable String userId) {
        return service.getAllRoomBookingsByUserId(userId);
    }
}