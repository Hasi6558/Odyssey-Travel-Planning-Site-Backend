package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.impl;


import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Favourite;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo.FavouriteRepository;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    private final FavouriteRepository favouriteRepository;

    @Autowired
    public FavouriteServiceImpl(FavouriteRepository favouriteRepository) {
        this.favouriteRepository = favouriteRepository;
    }

    @Override
    public Optional<Favourite> getFavouriteById(String id) {
        return favouriteRepository.findById(id);
    }

    @Override
    public Favourite addFavourite(Favourite favourite) {
        return favouriteRepository.save(favourite);
    }

    @Override
    public List<Favourite> getFavouritesByUserIdAndItemType(String userId, String itemType) {
        return favouriteRepository.findByUserIdAndItemType(userId, itemType);
    }
}
