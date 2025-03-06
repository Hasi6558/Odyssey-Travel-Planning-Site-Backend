package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation createReservation(Reservation reservation);

    List<Reservation> getAllReservations();

    Reservation getReservationById(String id);

    void deleteReservation(String id);

    List<Reservation> getReservationsByUserId(String userId);
}
