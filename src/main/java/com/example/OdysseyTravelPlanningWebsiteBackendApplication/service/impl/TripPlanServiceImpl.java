package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.impl;

// TripPlanServiceImpl.java
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.TripPlan;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo.TripPlanRepo;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.TripPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripPlanServiceImpl implements TripPlanService {

    @Autowired
    private TripPlanRepo tripPlanRepo;

    @Override
    public TripPlan createTripPlan(TripPlan tripPlan) {
        return tripPlanRepo.save(tripPlan);
    }

    @Override
    public Optional<TripPlan> getTripPlanById(String id) {
        return tripPlanRepo.findById(id);
    }

    @Override
    public TripPlan updateTripPlan(String id, TripPlan tripPlan) {
        if (tripPlanRepo.existsById(id)) {
            tripPlan.setId(id);
            return tripPlanRepo.save(tripPlan);
        }
        return null;  // Or throw an exception for "not found"
    }

    @Override
    public void deleteTripPlan(String id) {
        tripPlanRepo.deleteById(id);
    }

    @Override
    public List<TripPlan> getAllTripPlansByUser(String userId) {
        return tripPlanRepo.findByUserId(userId);
    }
}
