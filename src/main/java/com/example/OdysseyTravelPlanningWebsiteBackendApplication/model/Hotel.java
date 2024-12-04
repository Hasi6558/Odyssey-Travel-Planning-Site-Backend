package com.example.OdysseyTravelPlanningWebsiteBackendApplication.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "hotels")
public class Hotel {

    @Id
    private String id;

    private String title;
    private String location_city;
    private String location_country;
    private String location_map;
    private double ratings;
    private int review_count;
    private String description_short;
    private String description_long;
    private List<String> img_url;
    private List<String> facilities;
}
