package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Restaurant;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo.RestaurantRepository;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> getRestaurantById(String id) {
        return restaurantRepository.findById(id);
    }

    public Restaurant updateRestaurant(Restaurant newRestaurant, String id) {
        Optional<Restaurant> existingRestaurant = restaurantRepository.findById(id);
        if (existingRestaurant.isEmpty()) {
            throw new RuntimeException("cannot find any restaurant entity for this id :" + id);

        } else {

            Restaurant restaurant = existingRestaurant.get();
            restaurant.setTitle(newRestaurant.getTitle());
            restaurant.setLocation_city(newRestaurant.getLocation_city());
            restaurant.setLocation_country(newRestaurant.getLocation_country());
            restaurant.setLocation_map(newRestaurant.getLocation_map());
            restaurant.setRating(newRestaurant.getRating());
            restaurant.setDescription(newRestaurant.getDescription());
            restaurant.setReview_count(newRestaurant.getReview_count());
            restaurant.setImage_url(newRestaurant.getImage_url());
            restaurant.setFacilities(newRestaurant.getFacilities());
            restaurant.setFavourite_count(newRestaurant.getFavourite_count());

            return restaurantRepository.save(restaurant);
        }
    }

    @Override
    public boolean deleteRestaurant(String id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if (restaurant.isEmpty()) {
            throw new RuntimeException("cannot find any restaurant entity for this id :" + id);
        } else {
            restaurantRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public List<Restaurant> searchRestaurantsByCity(String searchTerm) {
        return restaurantRepository.findByCityContaining(searchTerm);
    }


}
