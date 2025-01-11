package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service;

// TripPlanService.java
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.TripPlan;

import java.util.List;
import java.util.Optional;

public interface TripPlanService {

    TripPlan createTripPlan(TripPlan tripPlan);
    Optional<TripPlan> getTripPlanById(String id);
    TripPlan updateTripPlan(String id, TripPlan tripPlan);
    void deleteTripPlan(String id);
    List<TripPlan> getAllTripPlansByUser(String userId);
}
