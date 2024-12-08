package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service;

import java.util.List;
import java.util.Optional;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Tour;

public interface TourService {
    public Tour saveTour(Tour tour);

    public List<Tour> getAllTours();

    public Optional<Tour> getTourById(String id);

    public Tour updateTour(Tour tour, String id);

    public boolean deleteTour(String id);

}
