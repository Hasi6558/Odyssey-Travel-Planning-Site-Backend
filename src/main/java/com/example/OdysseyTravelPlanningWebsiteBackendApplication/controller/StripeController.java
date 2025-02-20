package com.example.OdysseyTravelPlanningWebsiteBackendApplication.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.StripeService;
import com.stripe.exception.StripeException;

@RestController
@RequestMapping("/api/stripe")
@CrossOrigin
public class StripeController {
    @Autowired
    private StripeService stripeService;

    @PostMapping("/create-checkout-session")
    public Map<String, String> createCheckoutSession(@RequestBody Map<String, Object> request) throws StripeException {
        Long amount = ((Number) request.get("amount")).longValue();
        String currency = (String) request.get("currency");
        String roomTitle = (String) request.get("roomTitle");
        String roomId = (String) request.get("roomId");
        String userId = (String) request.get("userId");

        return stripeService.createCheckoutSession(amount, currency, roomTitle, roomId, userId);
    }
}
