package com.example.OdysseyTravelPlanningWebsiteBackendApplication.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role; // SUPER_ADMIN, ADMIN, REGULAR_USER
    private String address;
}
