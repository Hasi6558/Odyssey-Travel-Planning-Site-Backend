package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service;

import java.util.Map;

import com.stripe.exception.StripeException;

public interface StripeService {
    public Map<String, String> createCheckoutSession(Long amount, String currency, String roomTitle, String roomId,
            String userId)
            throws StripeException;

}
