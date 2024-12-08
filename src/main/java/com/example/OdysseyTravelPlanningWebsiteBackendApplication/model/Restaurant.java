package com.example.OdysseyTravelPlanningWebsiteBackendApplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "restaurant")
public class Restaurant {

    @Id
    private String id;
    private String title;
    private String location_city;
    private String location_country;
    private String location_map;
    private int rating;
    private String description;
    private int review_count;
    private String image_url;
    private String facilities;
    private int favourite_count;
   
}