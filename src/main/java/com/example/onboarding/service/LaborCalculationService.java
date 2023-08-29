package com.example.onboarding.service;

import com.example.onboarding.domain.LaborCalculationRequest;
import com.example.onboarding.domain.LaborCalculationResponse;

public class LaborCalculationService {
    public LaborCalculationResponse laborCalculationService (LaborCalculationRequest request)
    {
        float calculation = request.getLength()* request.getWidth()* request.getPricePerSqft();
        System.out.println("hi, here is string of request: "+request.toString());
        LaborCalculationResponse response = new LaborCalculationResponse(123456789, calculation);
        return response;
    }
}
