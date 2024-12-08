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
    private String locationCity;
    private String locationCountry;
    private String locationMap;
    private double ratings;
    private int reviewCount;
    private String descriptionShort;
    private String descriptionLong;
    private List<String> imgUrl;
    private List<String> facilities;
    private int favouriteCount;
}
