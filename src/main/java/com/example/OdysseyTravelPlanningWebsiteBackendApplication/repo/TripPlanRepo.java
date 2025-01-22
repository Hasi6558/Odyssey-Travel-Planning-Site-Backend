package com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo;

// TripPlanRepo.java
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.TripPlan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripPlanRepo extends MongoRepository<TripPlan, String> {
    // Custom query methods (if needed) can be added here
    List<TripPlan> findByUserId(String userId);
}

