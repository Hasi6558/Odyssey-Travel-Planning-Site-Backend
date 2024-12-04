package com.example.OdysseyTravelPlanningWebsiteBackendApplication.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Hotel;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.HotelService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin(origins = "*")
public class HotelController {

    @Autowired
    public HotelService hotelService;

    @PostMapping("/addHotel")
    public ResponseEntity<Hotel> postHotel(@RequestBody Hotel hotel) {
        return new ResponseEntity<Hotel>(hotelService.saveHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping("/getAllHotels")
    public ResponseEntity<List<Hotel>> getallHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        if (hotels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(hotels, HttpStatus.OK);
        }

    }

    @GetMapping("/getHotelById/{id}")
    public ResponseEntity<Hotel> getHotelBuId(@PathVariable String id) {
        Optional<Hotel> hotel = hotelService.getHotelById(id);
        if (hotel.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(hotel.get(), HttpStatus.OK);
        }
    }

    @PutMapping("/updateHotel/{id}")
    public ResponseEntity<Hotel> updteHotel(@RequestBody Hotel newHotel, @PathVariable String id) {

        Hotel hotel = hotelService.updateHotel(newHotel, id);
        if (hotel != null) {
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteHotel/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable String id) {
        boolean isHotelDeleted = hotelService.deleteHotel(id);
        if (isHotelDeleted) {
            return new ResponseEntity<>("Deleted the hotel : id " + id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot delete.Something wrong !", HttpStatus.NOT_FOUND);
        }
    }

}
