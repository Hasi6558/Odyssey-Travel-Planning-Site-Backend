package com.example.OdysseyTravelPlanningWebsiteBackendApplication.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Review {
        private String id;
        private String reviewdItemId;
        private String reviewerName;
        private int rate;
        private String comment;
        private LocalDate ratedAt;

}
