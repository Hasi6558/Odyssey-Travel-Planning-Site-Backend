package com.example.OdysseyTravelPlanningWebsiteBackendApplication.controller;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.TourPackage;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.TourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tour-packages")
@CrossOrigin
public class TourPackageController {
    @Autowired
    private TourPackageService service;

    @GetMapping
    public List<TourPackage> getAllTourPackages() {
        return service.getAllTourPackages();
    }

    @GetMapping("/{id}")
    public Optional<TourPackage> getTourPackageById(@PathVariable String id) {
        return service.getTourPackageById(id);
    }

    @PostMapping
    public TourPackage createTourPackage(@RequestBody TourPackage tourPackage) {
        return service.createTourPackage(tourPackage);
    }

    @PutMapping("/{id}")
    public TourPackage updateTourPackage(@PathVariable String id, @RequestBody TourPackage tourPackage) {
        return service.updateTourPackage(id, tourPackage);
    }

    @DeleteMapping("/{id}")
    public void deleteTourPackage(@PathVariable String id) {
        service.deleteTourPackage(id);
    }

    @GetMapping("/tour/{tourId}")
    public List<TourPackage> getTourPackagesByTourId(@PathVariable String tourId) {
        return service.getTourPackagesByTourId(tourId);
    }

}
