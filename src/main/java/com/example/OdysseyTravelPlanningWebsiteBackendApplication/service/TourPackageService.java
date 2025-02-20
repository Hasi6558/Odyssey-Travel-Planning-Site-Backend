package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.TourPackage;

import java.util.List;
import java.util.Optional;

public interface TourPackageService {
    List<TourPackage> getAllTourPackages();

    Optional<TourPackage> getTourPackageById(String id);

    TourPackage createTourPackage(TourPackage tourPackage);

    TourPackage updateTourPackage(String id, TourPackage tourPackage);

    void deleteTourPackage(String id);

    List<TourPackage> getTourPackagesByTourId(String tourId);
}
