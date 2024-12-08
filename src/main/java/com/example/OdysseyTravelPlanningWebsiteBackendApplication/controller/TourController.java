package com.example.OdysseyTravelPlanningWebsiteBackendApplication.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Tour;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.TourService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tours")
public class TourController {

    @Autowired
    private TourService tourService;

    @PostMapping("/addTour")
    public ResponseEntity<Tour> saveTour(@RequestBody Tour tour) {
        return new ResponseEntity<>(tourService.saveTour(tour), HttpStatus.CREATED);
    }

    @GetMapping("/getAllTours")
    public ResponseEntity<List<Tour>> getAllTours() {
        List<Tour> tours = tourService.getAllTours();
        if (tours.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(tours, HttpStatus.OK);
        }
    }

    @GetMapping("/getTourById/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable String id) {
        Optional<Tour> tour = tourService.getTourById(id);
        if (tour.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(tour.get(), HttpStatus.OK);
        }
    }

    @PutMapping("/updateTour/{id}")
    public ResponseEntity<Tour> updateTour(@RequestBody Tour newTour, @PathVariable String id) {
        try {
            Tour updatedTour = tourService.updateTour(newTour, id);
            return new ResponseEntity<>(updatedTour, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteTour/{id}")
    public ResponseEntity<String> deleteTour(@PathVariable String id) {
        try {
            boolean isTourDeleted = tourService.deleteTour(id);
            if (isTourDeleted) {
                return new ResponseEntity<>("Deleted the tour: id " + id, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cannot delete. Something went wrong!", HttpStatus.NOT_FOUND);
            }
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
