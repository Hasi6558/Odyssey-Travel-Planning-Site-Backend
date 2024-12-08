package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.HotelRoom;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo.HotelRoomRepository;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.HotelRoomService;

@Service
public class HotelRoomServiceImpl implements HotelRoomService {

    @Autowired
    private HotelRoomRepository hotelRoomRepository;

    @Override
    public HotelRoom saveHotelRoom(HotelRoom hotelRoom) {
        return hotelRoomRepository.save(hotelRoom);
    }

    @Override
    public List<HotelRoom> getAllHotelRooms() {
        return hotelRoomRepository.findAll();
    }

    @Override
    public Optional<HotelRoom> getHotelRoomById(String id) {
        return hotelRoomRepository.findById(id);
    }

    public HotelRoom updateHotelRoom(HotelRoom newHotelRoom, String id) {
        Optional<HotelRoom> existingHotelRoom = hotelRoomRepository.findById(id);
        if (existingHotelRoom.isEmpty()) {
            throw new RuntimeException("cannot find any hotel entity for this id :" + id);

        } else {

            HotelRoom hotelRoom = existingHotelRoom.get();

            hotelRoom.setHotelId(newHotelRoom.getHotelId());
            hotelRoom.setTitle(newHotelRoom.getTitle());
            hotelRoom.setSubtitle(newHotelRoom.getSubtitle());
            hotelRoom.setFacilities(newHotelRoom.getFacilities());
            hotelRoom.setPrice(newHotelRoom.getPrice());
            hotelRoom.setDiscountedPrice(newHotelRoom.getDiscountedPrice());
            hotelRoom.setAvalCount(newHotelRoom.getAvalCount());

            return hotelRoomRepository.save(hotelRoom);
        }
    }

    @Override
    public boolean deleteHotelRoom(String id) {
        Optional<HotelRoom> hotelRoom = hotelRoomRepository.findById(id);
        if (hotelRoom.isEmpty()) {
            throw new RuntimeException("cannot find any hotel entity for this id :" + id);
        } else {
            hotelRoomRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public List<HotelRoom> getHotelRoomsByHotelId(String hotelId) {
        return hotelRoomRepository.findByHotelId(hotelId);
    }

}
