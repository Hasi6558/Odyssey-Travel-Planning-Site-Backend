package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Hotel;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo.HotelRepository;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.HotelService;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Optional<Hotel> getHotelById(String id) {
        return hotelRepository.findById(id);
    }

    public Hotel updateHotel(Hotel newHotel, String id) {
        Optional<Hotel> existingHotel = hotelRepository.findById(id);
        if (existingHotel.isEmpty()) {
            throw new RuntimeException("cannot find any hotel entity for this id :" + id);

        } else {

            Hotel hotel = existingHotel.get();
            hotel.setTitle(newHotel.getTitle());
            hotel.setLocationCity(newHotel.getLocationCity());
            hotel.setLocationCountry(newHotel.getLocationCountry());
            hotel.setLocationMap(newHotel.getLocationMap());
            hotel.setRatings(newHotel.getRatings());
            hotel.setDescriptionShort(newHotel.getDescriptionShort());
            hotel.setDescriptionLong(newHotel.getDescriptionLong());
            hotel.setReviewCount(newHotel.getReviewCount());
            hotel.setImgUrl(newHotel.getImgUrl());
            hotel.setFacilities(newHotel.getFacilities());
            hotel.setFavouriteCount(newHotel.getFavouriteCount());

            return hotelRepository.save(hotel);
        }
    }

    @Override
    public boolean deleteHotel(String id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if (hotel.isEmpty()) {
            throw new RuntimeException("cannot find any hotel entity for this id :" + id);
        } else {
            hotelRepository.deleteById(id);
            return true;
        }
    }

}
