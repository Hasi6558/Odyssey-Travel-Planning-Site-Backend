package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Tour;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo.TourRepo;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.TourService;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepo tourRepository;

    @Override
    public Tour saveTour(Tour tour) {
        return tourRepository.save(tour);
    }

    @Override
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @Override
    public Optional<Tour> getTourById(String id) {
        return tourRepository.findById(id);
    }

    @Override
    public Tour updateTour(Tour newTour, String id) {
        Optional<Tour> existingTour = tourRepository.findById(id);
        if (existingTour.isEmpty()) {
            throw new RuntimeException("Cannot find any tour entity for this id: " + id);
        } else {
            Tour tour = existingTour.get();

            tour.setTitle(newTour.getTitle());
            tour.setLocation_city(newTour.getLocation_city());
            tour.setLocation_country(newTour.getLocation_country());
            tour.setLocation_map(newTour.getLocation_map());
            tour.setRating(newTour.getRating());
            tour.setDescription(newTour.getDescription());
            tour.setReview_count(newTour.getReview_count());
            tour.setImage_url(newTour.getImage_url());
            tour.setFacilities(newTour.getFacilities());
            tour.setFavourite_count(newTour.getFavourite_count());
            tour.setGuide_languages(newTour.getGuide_languages());
            tour.setPricePerOnePerson(newTour.getPricePerOnePerson());

            return tourRepository.save(tour);
        }
    }

    @Override
    public boolean deleteTour(String id) {
        Optional<Tour> tour = tourRepository.findById(id);
        if (tour.isEmpty()) {
            throw new RuntimeException("Cannot find any tour entity for this id: " + id);
        } else {
            tourRepository.deleteById(id);
            return true;
        }
    }
}
