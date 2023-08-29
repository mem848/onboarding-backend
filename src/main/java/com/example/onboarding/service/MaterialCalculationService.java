package com.example.onboarding.service;

import com.example.onboarding.domain.MaterialCalculationRequest;
import com.example.onboarding.domain.MaterialCalculationResponse;

public class MaterialCalculationService {
    public MaterialCalculationResponse materialCalculationService (MaterialCalculationRequest request)
    {
        float gallons_required = request.getLength()* request.getWidth()/ request.getSqftPerGallon();
        MaterialCalculationResponse response = new MaterialCalculationResponse(gallons_required);
        return response;
    }
}
