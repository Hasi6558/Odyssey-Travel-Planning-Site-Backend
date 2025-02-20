package com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.TourPackage;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TourPackageRepository extends MongoRepository<TourPackage, String> {
    List<TourPackage> findByTourId(String tourId);
}
