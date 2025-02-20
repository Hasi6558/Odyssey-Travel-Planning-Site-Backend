package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.impl;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.TourPackage;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo.TourPackageRepository;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.TourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TourPackageServiceImpl implements TourPackageService {

    @Autowired
    private TourPackageRepository repository;

    @Override
    public List<TourPackage> getAllTourPackages() {
        return repository.findAll();
    }

    @Override
    public Optional<TourPackage> getTourPackageById(String id) {
        return repository.findById(id);
    }

    @Override
    public TourPackage createTourPackage(TourPackage tourPackage) {
        return repository.save(tourPackage);
    }

    @Override
    public TourPackage updateTourPackage(String id, TourPackage tourPackage) {
        if (repository.existsById(id)) {
            tourPackage.setTourId(id);
            return repository.save(tourPackage);
        }
        return null;
    }

    @Override
    public void deleteTourPackage(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<TourPackage> getTourPackagesByTourId(String tourId) {
        return repository.findByTourId(tourId);
    }
}
