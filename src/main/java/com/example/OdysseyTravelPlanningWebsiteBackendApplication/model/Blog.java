package com.example.OdysseyTravelPlanningWebsiteBackendApplication.model;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    @Id
    private String id;
    private String title;
    private String description;
    private String imageurl;
    private String location;

}
