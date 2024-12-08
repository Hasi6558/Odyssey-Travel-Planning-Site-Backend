package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service;

import java.util.List;
import java.util.Optional;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.HotelRoom;

public interface HotelRoomService {

    public HotelRoom saveHotelRoom(HotelRoom hotelRoom);

    public List<HotelRoom> getAllHotelRooms();

    public Optional<HotelRoom> getHotelRoomById(String id);

    public HotelRoom updateHotelRoom(HotelRoom hotelRoom, String id);

    public boolean deleteHotelRoom(String id);

    public List<HotelRoom> getHotelRoomsByHotelId(String hotelId);
}
