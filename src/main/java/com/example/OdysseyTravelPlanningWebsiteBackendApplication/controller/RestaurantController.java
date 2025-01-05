package com.example.OdysseyTravelPlanningWebsiteBackendApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Restaurant;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.RestaurantService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    public RestaurantService restaurantService;

    @PostMapping("/addRestaurant")
    public ResponseEntity<Restaurant> postRestaurant(@RequestBody Restaurant restaurant) {
        return new ResponseEntity<Restaurant>(restaurantService.saveRestaurant(restaurant), HttpStatus.CREATED);
    }

    @GetMapping("/getAllRestaurant")
    public ResponseEntity<List<Restaurant>> getallRestaurant() {
        List<Restaurant> restaurant = restaurantService.getAllRestaurant();
        if (restaurant.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        }

    }

    @GetMapping("/getRestaurantById/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable String id) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurantById(id);
        if (restaurant.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(restaurant.get(), HttpStatus.OK);
        }
    }

    @PutMapping("/updateRestaurant/{id}")
    public ResponseEntity<Restaurant> updteRestaurant(@RequestBody Restaurant newRestaurant, @PathVariable String id) {

        Restaurant restaurant = restaurantService.updateRestaurant(newRestaurant, id);
        if (restaurant != null) {
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteRestaurant/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable String id) {
        boolean isRestaurantDeleted = restaurantService.deleteRestaurant(id);
        if (isRestaurantDeleted) {
            return new ResponseEntity<>("Deleted the restaurant : id " + id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot delete.Something wrong !", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/searchRestaurantsByCity")
    public List<Restaurant> searchRestaurantsByCity(@RequestParam("searchTerm") String searchTerm) {
        return restaurantService.searchRestaurantsByCity(searchTerm);
    }


}
