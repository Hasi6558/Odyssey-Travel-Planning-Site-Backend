package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Favourite;

import java.util.List;
import java.util.Optional;

public interface FavouriteService {
    Optional<Favourite> getFavouriteById(String id);
    Favourite addFavourite(Favourite favourite);
    List<Favourite> getFavouritesByUserIdAndItemType(String userId, String itemType);
}
