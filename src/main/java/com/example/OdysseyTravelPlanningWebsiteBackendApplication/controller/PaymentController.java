package com.example.OdysseyTravelPlanningWebsiteBackendApplication.controller;


import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.PaymentRequest;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/generate-hash")
    public String generateHash(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.generateHash(paymentRequest);
    }

    @PostMapping("/notify")
    public String handleNotification(@RequestBody String notificationData) {
        // Optional: Handle notifications from PayHere
        return paymentService.handleNotification(notificationData);
    }
}
