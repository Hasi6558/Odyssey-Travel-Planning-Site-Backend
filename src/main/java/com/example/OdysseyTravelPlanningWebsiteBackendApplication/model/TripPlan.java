package com.example.OdysseyTravelPlanningWebsiteBackendApplication.model;

// TripPlan.java
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document(collection = "tripPlans")
public class TripPlan {

    @Id
    private String id;
    private String userId;
    private List<List<List<Object>>> sections; // List of sections with each containing date, item title, and cost
    private double totalCost;
}
