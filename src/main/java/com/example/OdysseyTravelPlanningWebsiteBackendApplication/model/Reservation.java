package com.example.OdysseyTravelPlanningWebsiteBackendApplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "reservations")
public class Reservation {
    @Id
    private String id;
    private String userId;
    private String itemId;
    private String date;
    private String time;
    private int peopleCount;
    private String bookingDate;

    public Reservation(String userId, String itemId, String date, String time, int peopleCount) {
        this.userId = userId;
        this.itemId = itemId;
        this.date = date;
        this.time = time;
        this.peopleCount = peopleCount;
        this.bookingDate = new Date().toString();
    }

    // Getters and Setters
}
