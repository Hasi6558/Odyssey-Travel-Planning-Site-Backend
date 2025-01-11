package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service;


import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.PaymentRequest;

public interface PaymentService {
    String generateHash(PaymentRequest paymentRequest);
    String handleNotification(String notificationData); // Optional
}
