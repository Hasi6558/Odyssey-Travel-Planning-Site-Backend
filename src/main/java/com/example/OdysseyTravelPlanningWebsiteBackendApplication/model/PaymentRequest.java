package com.example.OdysseyTravelPlanningWebsiteBackendApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private String merchantId;
    private String orderId;
    private String amount;
    private String currency;
}
