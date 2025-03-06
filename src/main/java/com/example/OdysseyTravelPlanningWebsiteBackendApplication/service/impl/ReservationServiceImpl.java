package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.impl;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Reservation;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo.ReservationRepository;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        System.out.println("reservations ++++++++++++++" + reservations);
        return reservations;
    }

    @Override
    public Reservation getReservationById(String id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteReservation(String id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> getReservationsByUserId(String userId) {
        return reservationRepository.findByUserId(userId);
    }
}
