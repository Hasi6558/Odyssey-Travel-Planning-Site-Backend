package com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<Reservation, String> {
}

