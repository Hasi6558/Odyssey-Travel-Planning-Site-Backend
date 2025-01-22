package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service;

import java.util.List;
import java.util.Optional;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Restaurant;

public interface RestaurantService {

    public Restaurant saveRestaurant(Restaurant restaurant);

    public List<Restaurant> getAllRestaurant();

    public Optional<Restaurant> getRestaurantById(String id);

    public Restaurant updateRestaurant(Restaurant restaurant, String id);

    public boolean deleteRestaurant(String id);

    public List<Restaurant> searchRestaurantsByCity(String searchTerm);
}
