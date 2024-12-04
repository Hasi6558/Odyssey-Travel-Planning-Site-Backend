package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service;

import java.util.List;
import java.util.Optional;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Hotel;

public interface HotelService {

    public Hotel saveHotel(Hotel hotel);

    public List<Hotel> getAllHotels();

    public Optional<Hotel> getHotelById(String id);

    public Hotel updateHotel(Hotel hotel, String id);

    public boolean deleteHotel(String id);
}
