package com.example.OdysseyTravelPlanningWebsiteBackendApplication.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "tripPlans")
public class TripPlan {

    @Id
    private String id;
    private String userId;
    private List<List<List<Object>>> sections;
    private double totalCost;
    private String draftName;
    private int noOfSections;
    private LocalDate draftSavingTime;
}
