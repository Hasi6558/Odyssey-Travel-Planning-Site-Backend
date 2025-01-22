package com.example.OdysseyTravelPlanningWebsiteBackendApplication.controller;

// TripPlanController.java
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.TripPlan;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.TripPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trip-plans")
@CrossOrigin("*")
public class TripPlanController {

    @Autowired
    private TripPlanService tripPlanService;

    // Create a new Trip Plan
    @PostMapping("/save")
    public ResponseEntity<TripPlan> createTripPlan(@RequestBody TripPlan tripPlan) {
        TripPlan createdTripPlan = tripPlanService.createTripPlan(tripPlan);
        return new ResponseEntity<>(createdTripPlan, HttpStatus.CREATED);
    }

    // Get a Trip Plan by ID
    @GetMapping("/{id}")
    public ResponseEntity<TripPlan> getTripPlanById(@PathVariable String id) {
        Optional<TripPlan> tripPlan = tripPlanService.getTripPlanById(id);
        return tripPlan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a Trip Plan by ID
    @PutMapping("/{id}")
    public ResponseEntity<TripPlan> updateTripPlan(@PathVariable String id, @RequestBody TripPlan tripPlan) {
        TripPlan updatedTripPlan = tripPlanService.updateTripPlan(id, tripPlan);
        return updatedTripPlan != null ? ResponseEntity.ok(updatedTripPlan) : ResponseEntity.notFound().build();
    }

    // Delete a Trip Plan by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTripPlan(@PathVariable String id) {
        tripPlanService.deleteTripPlan(id);
        return ResponseEntity.noContent().build();
    }

    // Get all trip plans for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TripPlan>> getAllTripPlansByUser(@PathVariable String userId) {
        List<TripPlan> tripPlans = tripPlanService.getAllTripPlansByUser(userId);
        return tripPlans.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tripPlans);
    }
}

