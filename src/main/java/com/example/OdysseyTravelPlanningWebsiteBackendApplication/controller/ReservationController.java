package com.example.OdysseyTravelPlanningWebsiteBackendApplication.controller;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Reservation;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/reservations")
@CrossOrigin
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/{addReservation}")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable String id) {
        return reservationService.getReservationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable String id) {
        reservationService.deleteReservation(id);
    }
}
