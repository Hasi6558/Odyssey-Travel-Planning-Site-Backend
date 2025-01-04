package com.example.OdysseyTravelPlanningWebsiteBackendApplication.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.HotelRoom;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.HotelRoomService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/hotelRooms")
public class HotelRoomController {

    @Autowired
    public HotelRoomService hotelRoomService;

    @PostMapping("/addHotelRoom")
    public ResponseEntity<HotelRoom> saveHotelRoom(@RequestBody HotelRoom hotelRoom) {

        return new ResponseEntity<>(hotelRoomService.saveHotelRoom(hotelRoom), HttpStatus.CREATED);
    }

    @GetMapping("/getAllHotelRooms")
    public ResponseEntity<List<HotelRoom>> getAllHotelRooms() {
        List<HotelRoom> hotelRooms = hotelRoomService.getAllHotelRooms();
        if (hotelRooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(hotelRooms, HttpStatus.OK);
        }

    }

    @GetMapping("/getHotelRoomById/{id}")
    public ResponseEntity<HotelRoom> getHotelRoomById(@PathVariable String id) {
        Optional<HotelRoom> hotelRoom = hotelRoomService.getHotelRoomById(id);
        if (hotelRoom.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(hotelRoom.get(), HttpStatus.OK);
        }
    }

    @PutMapping("/updateHotelRoom/{id}")
    public ResponseEntity<HotelRoom> updteHotelRoom(@RequestBody HotelRoom newHotelRoom, @PathVariable String id) {

        HotelRoom hotelRoom = hotelRoomService.updateHotelRoom(newHotelRoom, id);
        if (hotelRoom != null) {
            return new ResponseEntity<>(hotelRoom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteHotel/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable String id) {
        boolean isHotelDeleted = hotelRoomService.deleteHotelRoom(id);
        if (isHotelDeleted) {
            return new ResponseEntity<>("Deleted the hotel : id " + id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot delete.Something wrong !", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllHotelRoomsByHotelId/{hotelId}")
    public ResponseEntity<List<HotelRoom>> getAllHotelRoomsByHotelId(@PathVariable String hotelId) {
        List<HotelRoom> hotelRooms = hotelRoomService.getAllHotelRoomsByHotelId(hotelId);
        return ResponseEntity.ok(hotelRooms);
    }

}
