package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.impl;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.PaymentRequest;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.PaymentService;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final String MERCHANT_SECRET = "MjczNTc2ODg5MTI2MDg1Nzg0MDExNTMyNTIwMzc0MTUwOTc5NTIw"; // Replace with your actual Merchant Secret

    @Override
    public String generateHash(PaymentRequest paymentRequest) {
        try {
            String hashString = paymentRequest.getMerchantId()
                    + paymentRequest.getOrderId()
                    + paymentRequest.getAmount()
                    + paymentRequest.getCurrency()
                    + MERCHANT_SECRET;

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(hashString.getBytes());
            byte[] digest = md.digest();

            // Convert byte array to hex string
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error generating hash", e);
        }
    }

    @Override
    public String handleNotification(String notificationData) {
        // Process PayHere notification data (optional implementation)
        return "Notification handled successfully!";
    }
}
