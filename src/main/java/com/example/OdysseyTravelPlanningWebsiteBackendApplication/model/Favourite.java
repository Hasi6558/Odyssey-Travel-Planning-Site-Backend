package com.example.OdysseyTravelPlanningWebsiteBackendApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "favouriteItems")
public class Favourite {

    @Id
    private String id;

    private String itemId;
    private String itemType;
    private String userId;

}
