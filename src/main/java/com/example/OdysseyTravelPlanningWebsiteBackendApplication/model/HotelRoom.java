package com.example.OdysseyTravelPlanningWebsiteBackendApplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "hotelRooms")
public class HotelRoom {
    @Id
    private String id;

    private String hotelId;
    private String title;
    private String subtitle;
    private String facilities;
    private String price;
    private String discountedPrice;
    private String avalCount;

}
