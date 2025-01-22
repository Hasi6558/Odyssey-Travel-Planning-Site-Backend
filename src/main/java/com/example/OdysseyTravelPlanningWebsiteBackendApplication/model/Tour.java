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
@Document(collection = "tours")
public class Tour {

    @Id
    private String id;
    private String title;
    private String location_city;
    private String location_country;
    private String location_map;
    private int rating;
    private String description;
    private int review_count;
    private List<String> image_url;
    private String facilities;
    private int favourite_count;
    private List<String> guide_languages;
    private String pricePerOnePerson;

}
